package io.bavs.client.model;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
@JsonAdapter(CatalogCodeError.Adapter.class)
public enum CatalogCodeError {
  
  _0("0"),
  
  _2("2"),
  
  _10("10"),
  
  _12("12"),
  
  _13("13"),
  
  _107("107"),
  
  _110("110"),
  
  _113("113"),
  
  _114("114"),
  
  _126("126"),
  
  _127("127"),
  
  _128("128"),
  
  _129("129"),
  
  _130("130"),
  
  _131("131"),
  
  _132("132"),
  
  _133("133"),
  
  _134("134"),
  
  _135("135"),
  
  _136("136"),
  
  _137("137"),
  
  _138("138"),
  
  _139("139"),
  
  _140("140"),
  
  _141("141");
  private String value;
  CatalogCodeError(String value) {
    this.value = value;
  }
  public String getValue() {
    return value;
  }
  @Override
  public String toString() {
    return String.valueOf(value);
  }
  public static CatalogCodeError fromValue(String text) {
    for (CatalogCodeError b : CatalogCodeError.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
  public static class Adapter extends TypeAdapter<CatalogCodeError> {
    @Override
    public void write(final JsonWriter jsonWriter, final CatalogCodeError enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }
    @Override
    public CatalogCodeError read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return CatalogCodeError.fromValue(String.valueOf(value));
    }
  }
}
