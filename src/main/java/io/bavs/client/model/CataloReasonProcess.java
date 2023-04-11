package io.bavs.client.model;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
@JsonAdapter(CataloReasonProcess.Adapter.class)
public enum CataloReasonProcess {
  
  _205("205"),
  
  _200_1("200.1"),
  
  _205_1("205.1"),
  
  _503_2("503.2"),
  
  _503_3("503.3"),
  
  _504_4("504.4");
  private String value;
  CataloReasonProcess(String value) {
    this.value = value;
  }
  public String getValue() {
    return value;
  }
  @Override
  public String toString() {
    return String.valueOf(value);
  }
  public static CataloReasonProcess fromValue(String text) {
    for (CataloReasonProcess b : CataloReasonProcess.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
  public static class Adapter extends TypeAdapter<CataloReasonProcess> {
    @Override
    public void write(final JsonWriter jsonWriter, final CataloReasonProcess enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }
    @Override
    public CataloReasonProcess read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return CataloReasonProcess.fromValue(String.valueOf(value));
    }
  }
}
