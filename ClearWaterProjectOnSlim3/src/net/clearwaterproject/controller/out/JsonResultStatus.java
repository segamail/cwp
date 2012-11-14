package net.clearwaterproject.controller.out;

/*
 * 処理ステータス結果をJSON形式返すためのデータ保持クラス
 */
public class JsonResultStatus {
	private String result;
	private int    error_code;
	private int    error_type;
	private String error_text;
	
	public JsonResultStatus(String result, int e_code, int e_type, String e_text){
	    this.result = result;
	    this.error_code = e_code;
	    this.error_type = e_type;
	    this.error_text = e_text;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getError_code() {
		return error_code;
	}
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
	public int getError_type() {
		return error_type;
	}
	public void setError_type(int error_type) {
		this.error_type = error_type;
	}
	public String getError_text() {
		return error_text;
	}
	public void setError_text(String error_text) {
		this.error_text = error_text;
	}
	
	
	
	

}
