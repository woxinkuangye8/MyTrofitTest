package yuzhentao.retrofitdemo;
public class  Person{
    private String  username;
    private  String  email;
    private  String  addr;
    private  int  age;
    private Person(Builder builder)
    {
        this.username=builder.username;
        this.email=builder.email;
        this.addr=builder.addr;
        this.age=builder.age;
    }
   static class Builder {
        private String username;
        private String email;
        private String addr;
        private int age;

        public Builder setUserName(String username)
        {
            this.username=username;
                return this;
        }
        public  Builder setEmail(String email)
        {
            this.email=email;
            return this;
        }
        public  Builder setAddr(String addr)
        {
            this.addr=addr;
            return this;
        }
        public  Builder setAge(int age)
        {
            this.age=age;
            return this;
        }
        public Person build()
        {
            return new Person(this);
        }
    }


}