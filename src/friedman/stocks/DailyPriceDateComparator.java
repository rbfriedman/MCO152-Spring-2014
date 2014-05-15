package friedman.stocks;

import java.util.Comparator;

public class DailyPriceDateComparator implements Comparator<DailyPrice>{
	
	@Override
	public int compare(DailyPrice a, DailyPrice b) {
		// TODO Auto-generated method stub
		if(a.getDate().before(b.getDate())){
			return 1;
		}
		else if(a.getDate().after(b.getDate())){
			return -1;
		}else{
			return 0;
		}
	}
	
	public boolean equals(DailyPrice a, DailyPrice b){
		return a.getDate().equals(b.getDate());
	}

}
