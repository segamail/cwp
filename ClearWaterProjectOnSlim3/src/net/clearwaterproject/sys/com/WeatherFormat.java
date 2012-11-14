package net.clearwaterproject.sys.com;

/*天気の名称を返すクラス。将来的に多言語対応でなくなる予定*/
public class WeatherFormat {
	
	private WeatherFormat(){
		//
	}
	
	public static String getWeatherNm(int weatherId){
		if (weatherId==1) {
			return "晴れ";
		}else if(weatherId==2){
			return "くもり";
		}else if(weatherId==3){
			return "雨";
		}else if(weatherId==4){
			return "暴風雨";
		}else if(weatherId==5){
			return "雪";
		}else if(weatherId==6){
			return "暴風雪";
		}else if(weatherId==7){
			return "雷";
		}else if(weatherId==12){
			return "晴れのちくもり";
		}else if(weatherId==13){
			return "晴れのち雨";
		}else if(weatherId==21){
			return "くもりのち晴れ";
		}else if(weatherId==23){
			return "っくもりのち雨";
		}else if(weatherId==31){
			return "雨のち晴れ";
		}else if(weatherId==32){
			return "雨のりくもり";
		}
		return "未登録";
	}

}
