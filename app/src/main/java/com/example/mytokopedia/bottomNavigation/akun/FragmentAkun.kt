    package com.example.mytokopedia.bottomNavigation.akun

    import android.content.Intent
    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.navigation.fragment.findNavController
    import com.example.mytokopedia.R
    import com.example.mytokopedia.bottomNavigation.transaksi.FragmentTransaksi
    import com.example.mytokopedia.databinding.FragmentAkunBinding
    import com.google.android.material.bottomnavigation.BottomNavigationView


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
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }