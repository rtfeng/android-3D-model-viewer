package org.andresoviedo.app.model3D.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.andresoviedo.dddmodel2.R;

/**
 * Created by lyk on 11/4/17.
 */

public class SelectionActivity extends Activity {

    private Button btnBunny, btnGargoyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_selection);
        this.btnBunny = (Button) this.findViewById(R.id.btn_bunny);
        this.btnGargoyle = (Button) this.findViewById(R.id.btn_gargoyle);

        this.setupButtons();
    }

    private void setupButtons() {
        this.btnBunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectionActivity.this.getApplicationContext(), ModelActivity.class);
                Bundle b = new Bundle();
                b.putString("assetDir", "models/");
                b.putString("assetFilename", "bunny.m");
                b.putBoolean("use_model_file", true);
                intent.putExtras(b);
                SelectionActivity.this.startActivity(intent);
            }
        });

        this.btnGargoyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectionActivity.this.getApplicationContext(), ModelActivity.class);
                Bundle b = new Bundle();
                b.putString("assetDir", "models/");
                b.putString("assetFilename", "gargoyle.m");
                b.putBoolean("use_model_file", true);
                intent.putExtras(b);
                SelectionActivity.this.startActivity(intent);
            }
        });
    }
}
