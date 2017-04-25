package yuzhentao.retrofitdemo;

/**
 * Created by 01 on 2017/4/24.
 */

public class User implements UserInterface {

    @Override
    public String getName() {
        return "li";
    }

    @Override
    public int getAge() {
        return 18;
    }
}
