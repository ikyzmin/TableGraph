package mvc;

public interface BaseView<T> {

     void setController(T baseController);
     void setModel(BaseModel model);

}
