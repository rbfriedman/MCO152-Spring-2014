package friedman.stocks;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

public class AmexData {
	private Map<String, List<DailyPrice>> stocks;
	private CSVReader reader;

	public AmexData() throws IOException {
		stocks = new HashMap<String, List<DailyPrice>>();
		// getAllStockSymbols(new File("companylist.csv"));

		File folder = new File("resources/amex");
		try {
			processCSVFiles(folder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}

	}

	/*
	 * private void getAllStockSymbols(File file) throws Exception {
	 * 
	 * 
	 * 
	 * List<String[]> rawStockSymbols =reader.readAll(); for(int rawData = 1;
	 * rawData <rawStockSymbols.size();rawData++){ List<DailyPrice> list = new
	 * ArrayList<DailyPrice>(); stocks.put(rawStockSymbols.get(rawData)[1],list
	 * );
	 * 
	 * }
	 * 
	 * reader.close(); }
	 */

	private void processCSVFiles(File folder) throws IOException {

		for (int k = 0; k < 15; k++) {
			File fileEntry = folder.listFiles()[k];
			if (fileEntry.isDirectory()) {
				processCSVFiles(folder);
			} else if (fileEntry.getName().endsWith(".csv")) {
				reader = new CSVReader(new FileReader(fileEntry));
				List<String[]> rawDailyPrice = reader.readAll();
				for (int i = 1; i < rawDailyPrice.size(); i++) {
					String[] rawData = rawDailyPrice.get(i);
					if (!stocks.containsKey(rawData[1])) {
						stocks.put(rawData[1], new ArrayList<DailyPrice>());
					}
					if (rawData.length == 9) {
						String[] tokens = rawData[2].split("-");
						
						Date date = new GregorianCalendar(
								Integer.parseInt(tokens[0]),
								Integer.parseInt(tokens[1]),
								Integer.parseInt(tokens[2])).getTime();
						stocks.get(rawData[1]).add(
								new DailyPrice(rawData[0], rawData[1], date,
										Double.parseDouble(rawData[3]), Double
												.parseDouble(rawData[4]),
										Double.parseDouble(rawData[5]), Double
												.parseDouble(rawData[6]),
										Integer.parseInt(rawData[7]), Double
												.parseDouble(rawData[8])));
					}
				}
				System.out.println(fileEntry.getName() + " processed");
			} else {
				System.out.println(fileEntry.getName()
						+ " can not be processed because it is not a csv file");
			}
		}
		// read.close();
	}

	public boolean contains(String symbol) {
		return stocks.containsKey(symbol);
		
	}

	public List<DailyPrice> getPrices(String symbol) {
		DailyPriceDateComparator comp = new DailyPriceDateComparator();
		List<DailyPrice> orderedStocks = new ArrayList<DailyPrice>();
		try{
		orderedStocks.addAll(stocks.get(symbol));
		}catch(NullPointerException npe){
			/*
			 * Nothing is done when the npe is caught, the program runs
			 * as it did beforehand
			 */
		}
		/*
		 * Iterator<DailyPrice> it = stocks.get(symbol).iterator();
		 * while(it.hasNext()){ comp.compare(it.next(), b) } stocks.get(symbol)
		 */

		Collections.sort(orderedStocks, comp);
		return orderedStocks;
	}

	public List<DailyPrice> getPricesIter(String symbol, Date startDate,
			Date endDate) {
		List<DailyPrice> orderedStocks = new ArrayList<DailyPrice>();
		Iterator<DailyPrice> it = getPrices(symbol).iterator();
		while (it.hasNext()) {
			DailyPrice current = it.next();
			if (current.getDate().after(startDate)
					&& current.getDate().before(endDate)) {
				orderedStocks.add(current);
			}
		}

		return orderedStocks;
	}
	public List<DailyPrice> getPrices(String symbol, String date1, String date2){
		String[] tokens =date1.split("-");
		GregorianCalendar date = new GregorianCalendar();
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		date.set(Calendar.YEAR, Integer.parseInt(tokens[0]));
		date.set(Calendar.MONTH, Integer.parseInt(tokens[1])-1);
		date.set(Calendar.DATE, Integer.parseInt(tokens[2]));
		Date start = date.getTime();
		tokens = date2.split("-");
		date.set(Calendar.YEAR, Integer.parseInt(tokens[0]));
		date.set(Calendar.MONTH, Integer.parseInt(tokens[1])-1);
		date.set(Calendar.DATE, Integer.parseInt(tokens[2]));
		Date end = date.getTime();
		return getPrices(symbol,start,end);
	}
	public List<DailyPrice> getPrices(String symbol, Date startDate,
			Date endDate) {
		List<DailyPrice> orderedStocks = new ArrayList<DailyPrice>();
		List<DailyPrice> aList = getPrices(symbol);
		Iterator<DailyPrice> p = aList.iterator();
		int i =0;
		while(p.hasNext() && i<50){
			System.out.println(p.next());
			i++;
		}
		for (DailyPrice d : aList) {
			System.out.println(d.getDate());
			if (d.getDate().compareTo(startDate) >= 0
					&& d.getDate().compareTo(endDate) <= 0) {
				System.out.println(d.getDate());
				orderedStocks.add(d);
			}
		}
		return orderedStocks;
	}

}
