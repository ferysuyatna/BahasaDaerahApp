package com.e.bahasaapp.dictionary;

import com.e.bahasaapp.model.DictionaryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface RequestInteface {
    @GET("dataBahasaBugis.json")
    Call<List<DictionaryModel>> getBugisJson();
    @GET("dataBahasaSunda.json")
    Call<List<DictionaryModel>> getSundaJson();
    @GET("dataBahasaBali.json")
    Call<List<DictionaryModel>> getBaliJson();
}
