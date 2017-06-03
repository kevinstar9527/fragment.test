package kevinstar1.edu.cn.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.push_right_in,R.anim.push_right_out,R.anim.push_left_in,R.anim.push_left_out);//设置进入，退出动画
                fragmentTransaction.addToBackStack(null);//加入回退栈
                fragmentTransaction.add(R.id.frameLayout,TestFragment.instantiate(MainActivity.this,TestFragment.class.getName()));
                fragmentTransaction.commitAllowingStateLoss();
            }
        });

    }

}
