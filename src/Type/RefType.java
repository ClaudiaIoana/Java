package Type;

import Value.RefValue;
import Value.Value;

public class RefType implements Type{
    Type inner;

    public RefType(Type inner){
        this.inner = inner;
    }

    public Type getInner(){
        return inner;
    }

    @Override
    public boolean equals(Object another){
        if (another instanceof RefType)
            return inner.equals(((RefType) another).getInner());
        else
            return false;
    }

    @Override
    public Type deepCopy() {
        return new RefType(inner.deepCopy());
    }

    @Override
    public Value defaultValue() {
        return new RefValue(0, inner);
    }

    public String toString(){
        return "Ref(" + inner.toString()+")";
    }

}
