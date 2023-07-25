package com.raduldul.rajagaluhkidul.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.database_room.UserData
import com.raduldul.rajagaluhkidul.databinding.FragmentLoginBinding
import com.raduldul.rajagaluhkidul.datastore_preferences.UserManager
import com.raduldul.rajagaluhkidul.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


@AndroidEntryPoint
class LoginFragment : Fragment() {
   private lateinit var binding: FragmentLoginBinding
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private val REQ_CODE = 2
    private lateinit var auth: FirebaseAuth
    private lateinit var userManager: UserManager
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)
        binding.tvRegisterLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        auth = Firebase.auth
        userManager = UserManager.getInstance(requireContext())

        FirebaseApp.initializeApp(requireContext())

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
        auth = FirebaseAuth.getInstance()

        binding.btnGoogleSignIn.setOnClickListener {
            Toast.makeText(requireContext(), "Logging In", Toast.LENGTH_SHORT).show()
            signInGoogle()
        }

        binding.btnLogin.setOnClickListener {
            login()
        }
        binding.tvRegisterLogin.setOnClickListener {
            newRegist()
        }


    }

    @Suppress("OVERRIDE_DEPRECATION", "DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_CODE) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleResult(task)
        }
    }

    override fun onStart() {
        super.onStart()
        if (GoogleSignIn.getLastSignedInAccount(requireContext()) != null) {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }

    @Suppress("DEPRECATION")
    private fun signInGoogle() {
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, REQ_CODE)
    }

    private fun handleResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount? = completedTask.getResult(ApiException::class.java)
            if (account != null) {
                UpdateUI(account)
            }
        } catch (e: ApiException) {
            Toast.makeText(requireContext(), e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    // this is where we update the UI after Google signin takes place
    @Suppress("OPT_IN_USAGE", "DeferredResultUnused", "FunctionName")
    private fun UpdateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                GlobalScope.async {
                    userManager.saveData(username = account.displayName.toString(), email = account.email.toString(), is_login_key = true)
                }
                saveUser(username = account.displayName.toString(), email = account.email.toString(), password = "googleSignIn")
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }
    }

    @Suppress("SameParameterValue")
    private fun saveUser(username : String, email : String, password : String){
        userViewModel.insertUser(UserData(0,username,email,password))
    }

    @Suppress("OPT_IN_USAGE")
    private fun checkUser(email: String, password: String) {
        userViewModel.checkUser(email, password).observe(viewLifecycleOwner) {
            if (it == null) {
                Toast.makeText(requireContext(), "Email or password Salah", Toast.LENGTH_SHORT)
                    .show()
            } else {
                GlobalScope.launch {
                    userManager.saveData(username = it.username,email, is_login_key = true)
                }
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }
    }

    private fun login() {
        val emailLogin = binding.etEmailLogin.text.toString()
        val passwordLogin = binding.etPasswordLogin.text.toString()
        checkUser(emailLogin,passwordLogin)
    }

    private fun newRegist() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }



}