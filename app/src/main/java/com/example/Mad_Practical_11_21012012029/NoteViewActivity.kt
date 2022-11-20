package com.example.Mad_Practical_11_21012012029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.Mad_Practical_11_21012012029.databinding.ActivityNoteViewBinding


class NoteViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_note_view)
        binding = ActivityNoteViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        var note = intent.getSerializableExtra("Object") as Note
        with(note)
        {
            binding.noteTitle.text = this.title
            binding.noteSubtitle.text = this.subTitle
            binding.noteContent.text = this.Description
            binding.noteDate.text = this.modifiedTime
            this.calcReminder()
            if (this.isReminder){
                binding.noteReminderDateTime.visibility = View.VISIBLE

                binding.noteReminderDateTime.text = this.getReminderText()
            }
            else{
                binding.noteReminderDateTime.visibility = View.GONE
            }
        }
    }
}