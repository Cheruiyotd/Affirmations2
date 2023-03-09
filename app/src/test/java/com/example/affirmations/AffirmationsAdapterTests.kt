package com.example.affirmations

import android.content.Context
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock

class AffirmationsAdapterTests {
    private val context = mock(
        Context::class.java
    )

    @Test
    fun adapterSize() {
        val data = Datasource().loadAffirmations()
        val adapter = ItemAdapter(context, data)
        myAssert(data.size, adapter.itemCount)
        val dataset = listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation10, R.drawable.image10)
        )
        myAssert(dataset.size, ItemAdapter(context, dataset).itemCount)

    }

    private fun myAssert(myDatasize: Any, adapterDataSize: Any) {
        assertEquals("ItemAdapter is not the correct size", myDatasize, adapterDataSize)
    }
}