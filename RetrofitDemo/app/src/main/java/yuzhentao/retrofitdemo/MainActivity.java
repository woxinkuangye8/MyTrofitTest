package yuzhentao.retrofitdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 主界面
 *
 * @author yuzhentao
 */
public class MainActivity extends Activity {

    private static final String BASE_URL = "http://apis.baidu.com";
    private static final String API_KEY = "";//这里输入Api Key

    private Context context;

    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        context = this;
        et = (EditText) findViewById(R.id.edittext_activity_main);
        findViewById(R.id.button_activity_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                query();
                myInvoke();
            }
        });
    }

    public void PointTest()
    {
        Point point =new Point();
        point.setX(15);//int-->Integer-->Object
        point.setY(10);
        int x=(int)point.getX();
        Log.i("test",x+"");

        PointT<Integer,Integer> pointT=new PointT<Integer, Integer>();
        pointT.setX(22);
        pointT.setY(55);

    }


    private  void myQuery()
    {

        Person person=new Person.Builder()
                .setAddr("shanghai")
                .setAge(18)
                .setEmail("123456@126.com")
                .setUserName("zhangsan")
                .build();
    }

    private void myInvoke(){
        MyInvocationHandler myInvocationHandler=new MyInvocationHandler(new User());
        UserInterface userInterface=(UserInterface) Proxy.newProxyInstance(User.class.getClassLoader(),User.class.getInterfaces(),myInvocationHandler);
        Log.i("Test",userInterface.getName());
        Log.i("Test",userInterface.getAge()+"");
    }

    private  static  String zhiHuUrl="https://zhuanlan.zhihu.com";
    private void callZhiHu()
    {
        Retrofit retrofit=new Retrofit.Builder()
                           .baseUrl(zhiHuUrl)
                           .addConverterFactory(GsonConverterFactory.create())
                           .build();

    }

    private void query() {

//        Retrofit mRetrofit=new Retrofit.Builder();

        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();
        PhoneService phoneService = retrofit.create(PhoneService.class);
        Call<PhoneResult> phoneResultCall = phoneService.getResult(API_KEY, et.getText().toString());
        phoneResultCall.enqueue(new Callback<PhoneResult>() {
            @Override
            public void onResponse(Call<PhoneResult> call, Response<PhoneResult> response) {
                if (response.isSuccessful()) {
                    Log.e("yuzhentao", "获取成功");


                    try{
                        Person person=new Person.Builder().build();
                        Method method=Person.class.getMethod("getUsername", String.class);
                        method.invoke(person,"123");

                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                    PhoneResult phoneResult = response.body();
                    if (phoneResult != null) {
                        PhoneResult.RetDataEntity retDataEntity = phoneResult.getRetData();
                        Toast.makeText(context, retDataEntity.getCity(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<PhoneResult> call, Throwable t) {
                Log.e("yuzhentao", "获取失败");
            }
        });
    }

}