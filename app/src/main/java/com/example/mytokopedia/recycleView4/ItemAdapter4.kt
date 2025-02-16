import android.content.Intent
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytokopedia.recycleView4.DetailRecycler4
import com.example.mytokopedia.databinding.ItemList4Binding
import com.example.mytokopedia.recycleView4.Item4


class ItemAdapter4(private val productList: List<Item4>) :
    RecyclerView.Adapter<ItemAdapter4.ProductViewHolder>() {

    inner class ProductViewHolder(private val binding: ItemList4Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Item4) {
            binding.imgprodak.setImageResource(product.imageRes)
            binding.tvNamaProduk.text = product.namaProduk
            binding.tvHarga.text = product.harga

            if (product.hargaAsli != null) {
                binding.tvHargaAsli.visibility = View.VISIBLE
                binding.tvHargaAsli.text = product.hargaAsli
            } else {
                binding.tvHargaAsli.visibility = View.GONE
            }

            if (product.gratisOngkir) {
                binding.tvGratisOngkir.visibility = View.VISIBLE
            } else {
                binding.tvGratisOngkir.visibility = View.GONE
            }

            if (product.cod) {
                binding.tvCOD.visibility = View.VISIBLE
            } else {
                binding.tvCOD.visibility = View.GONE
            }
            // Menambahkan efek coret pada harga asli
            binding.tvHargaAsli.paintFlags = binding.tvHargaAsli.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemList4Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.bind(product)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailRecycler4::class.java).apply {
                putExtra("imageRes", product.imageRes)
                putExtra("namaProduk", product.namaProduk)
                putExtra("harga", product.harga)
                putExtra("gratisOngkir", product.gratisOngkir)

            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = productList.size
}