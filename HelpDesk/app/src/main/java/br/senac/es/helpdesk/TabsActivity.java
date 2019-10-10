package br.senac.es.helpdesk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class TabsActivity extends AppCompatActivity {

    private TabAdapter tabadapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
   final Button btnNew = (Button) findViewById(R.id.btn_new_chamado);
        viewPager =(ViewPager) findViewById(R.id.viewPager);
        tabLayout=(TabLayout) findViewById(R.id.tabLayout);



        tabadapter = new TabAdapter( getSupportFragmentManager());
        tabadapter.addFragment( new Tab1Fragment() , "Abertos");
        tabadapter.addFragment( new Tab2Fragment(), "Fechados");

        viewPager.setAdapter(tabadapter);
        tabLayout.setupWithViewPager(viewPager);

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TabsActivity.this, newChamado.class);
                startActivity(intent);
            }
        });
    }
}
