package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rv_list = findViewById<RecyclerView>(R.id.rv_list)
        val iv_list = findViewById<ImageView>(R.id.iv_list)
        val iv_grid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()
        rv_list.adapter = adapter
        adapter.submitList(contacts)
        rv_list.layoutManager = LinearLayoutManager(this)
            //.apply {
                //orientation = LinearLayoutManager.VERTICAL //BY DEFAULT IS VERTICAL, I LEFT THIS HERE SO I KNOW HOW TO CHANGE IN THE FUTURE
            //}
        iv_grid.setOnClickListener {
            rv_list.layoutManager = GridLayoutManager(this, 2)
        }

        iv_list.setOnClickListener {
            rv_list.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener {
            contact ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("image", contact.image)
            startActivity(intent)
        }
    }
}

val contacts = listOf(
    contact(
        name = "Ana",
        phone = "15752839100",
        image = R.drawable.sample1
    ),
    contact(
        name = "Bruno",
        phone = "15752839100",
        image = R.drawable.sample2
    ),
    contact(
        name = "Carlos",
        phone = "15752839100",
        image = R.drawable.sample3
    ),
    contact(
        name = "Daniel",
        phone = "15752839100",
        image = R.drawable.sample4
    ),
    contact(
        name = "Eduardo",
        phone = "15752839100",
        image = R.drawable.sample5
    ),
    contact(
        name = "Fernanda",
        phone = "15752839100",
        image = R.drawable.sample6
    ),
    contact(
        name = "Gabriel",
        phone = "15752839100",
        image = R.drawable.sample7
    ),
    contact(
        name = "Henrique",
        phone = "15752839100",
        image = R.drawable.sample8
    ),
    contact(
        name = "Isabela",
        phone = "15752839100",
        image = R.drawable.sample9
    ),
    contact(
        name = "João",
        phone = "15752839100",
        image = R.drawable.sample10
    ),
    contact(
        name = "Karina",
        phone = "15752839100",
        image = R.drawable.sample11
    ),
    contact(
        name = "Lucas",
        phone = "15752839100",
        image = R.drawable.sample12
    ),
    contact(
        name = "Maria",
        phone = "15752839100",
        image = R.drawable.sample13
    ),
    contact(
        name = "Natália",
        phone = "15752839100",
        image = R.drawable.sample14
    ),
    contact(
        name = "Otávio",
        phone = "15752839100",
        image = R.drawable.sample15
    ),
    contact(
        name = "Paula",
        phone = "15752839100",
        image = R.drawable.sample16
    )
)