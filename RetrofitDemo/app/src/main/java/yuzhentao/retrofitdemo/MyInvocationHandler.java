package yuzhentao.retrofitdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 01 on 2017/4/24.
 */

public class MyInvocationHandler implements InvocationHandler {
    private  Object target;
    public  MyInvocationHandler(Object object)
    {

        target=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("getName"))
        {
            String nameRef=(String)method.invoke(target,args);
            return  nameRef+"heihei";
        }else  if(method.getName().equals("getAge"))
        {
            int ageRef=(int)method.invoke(target,args);
            return  ageRef+20;
        }
        return null;
    }
}
