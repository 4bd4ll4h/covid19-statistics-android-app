package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.abd4ll4h.covid19hope.DataBinderMapperImpl());
  }
}
