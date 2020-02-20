package ru.netology.lists;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        List<Map<String, String>> values = prepareContent();

        BaseAdapter listContentAdapter = createAdapter(values);

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String, String>> values) {
        SimpleAdapter adapter = new SimpleAdapter(this, values, R.layout.list_item,
                new String[]{"paragraph", "number"}, new int[]{R.id.paragraph, R.id.number});
        return adapter;
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        String[] sourceStrings = getString(R.string.large_text).split("\n\n");

        List<Map<String, String>> list = new ArrayList<>();

        for (int i = 0; i < sourceStrings.length; i++) {
            Map<String, String> curValue = new HashMap<>();
            curValue.put("paragraph", sourceStrings[i]);
            curValue.put("number", String.valueOf(sourceStrings[i].length()));
            list.add(curValue);
        }
        return list;
    }
}
