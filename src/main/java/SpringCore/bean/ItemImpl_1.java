package SpringCore.bean;

public class ItemImpl_1 implements Item{
    @Override
    public String getDetail() {
        return " Item -1 descption : Nice product for hair";
    }
    @Override
    public String getName() {
        return "GK-1";
    }

    @Override
    public Long getCode() {
        return 100L;
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
