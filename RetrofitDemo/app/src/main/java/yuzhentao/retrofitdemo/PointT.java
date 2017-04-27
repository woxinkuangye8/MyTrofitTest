package yuzhentao.retrofitdemo;

/**
 * Created by 01 on 2017/4/26.
 */

public class PointT<T1,T2> {
    T1 x;
    T2 y;

    public T1 getX() {
        return x;
    }

    public void setX(T1 x) {
        this.x = x;
    }

    public T2 getY() {
        return y;
    }

    public void setY(T2 y) {
        this.y = y;
    }

    public <T1,T2> void  printP(T1 x,T2 y){


    }
}
