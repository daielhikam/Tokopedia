    package com.example.mytokopedia.bottomNavigation.akun

    import ProfileViewModel
    import ReadProfileResponse
    import android.content.Intent
    import android.os.Bundle
    import android.util.Log
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.lifecycle.Observer
    import androidx.lifecycle.ViewModelProvider
    import androidx.navigation.fragment.findNavController
    import com.bumptech.glide.Glide
    import com.example.mytokopedia.R
    import com.example.mytokopedia.data.retrofit.ApiConfig
    import com.example.mytokopedia.profile.EditProfile
    import com.example.mytokopedia.databinding.FragmentAkunBinding
    import com.google.android.material.bottomnavigation.BottomNavigationView
    import retrofit2.Call
    import retrofit2.Callback
    import retrofit2.Response


    class FragmentAkun : Fragment() {

        private var _binding: FragmentAkunBinding? = null
        private val binding get() = _binding!!
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = FragmentAkunBinding.inflate(inflater, container, false)
            return binding.root
        }


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            getProfile()

            binding.tvDaftarTransaksi.setOnClickListener {
                val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.nav_view)
                bottomNav?.selectedItemId = R.id.navigation_transaksi
            }

            binding.tvUlasan.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_akun_to_navigation_ulasan2)
            }
            binding.tvBeliLagi.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_akun_to_fragmentBelilagi)
            }
            binding.tvWishlist.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_akun_to_fragmentWhislist)
            }
            binding.tvTokoDiFollow.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_akun_to_fragmentToko)
            }
            binding.tvPesananDikomplain.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_akun_to_fragmentPesanan)
            }
            binding.tvBantuanTokped.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_akun_to_fragmentBantuan)
            }
            binding.tvScanKodeQR.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_akun_to_fragmentScan)
            }
            binding.bukaToko.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_akun_to_fragmentBukaToko)
            }
            binding.daftarAffiliate.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_akun_to_fragmentAffiliate)
            }
            binding.gratisOngkir.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_akun_to_fragmentGratisOngkir)
            }
            binding.setting.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_akun_to_settingAkun)
            }
            binding.circleImageView.setOnClickListener {
                val intent = Intent(requireContext(), EditProfile::class.java)
                startActivity(intent)
            }
        }
            private fun getProfile() {
                ApiConfig.getApiService().getProfileData().enqueue(object :
                    Callback<ReadProfileResponse> {
                    override fun onResponse(
                        call: Call<ReadProfileResponse>,
                        response: Response<ReadProfileResponse>
                    ) {
                        if (response.isSuccessful) {
                            val profile = response.body()?.data?.get(0) // Ambil data pertama dari array 'data'
                            if (profile != null) {
                                val imageUrl = profile.fotoProfil
                                if (!imageUrl.isNullOrEmpty()) {

                                    Glide.with(binding.circleImageView.context)
                                        .load(imageUrl)
                                        .into(binding.circleImageView) // Set gambar di EditProfileActivity
                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<ReadProfileResponse>, t: Throwable) {
                        Log.e("EditProfileActivity", "Error: ${t.message}")
                    }
                })
            }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }