
package com.example.demo.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubmittedFormRawData {

    @SerializedName("qa")
    @Expose
    private List<Qa> qa = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubmittedFormRawData() {
    }

    /**
     * 
     * @param qa
     */
    public SubmittedFormRawData(List<Qa> qa) {
        super();
        this.qa = qa;
    }

    public List<Qa> getQa() {
        return qa;
    }

    public void setQa(List<Qa> qa) {
        this.qa = qa;
    }

}
