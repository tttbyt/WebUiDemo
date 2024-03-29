package viettel.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import viettel.com.entity.ecg.EcgCurrent;
import viettel.com.service.AvgService;
import viettel.com.service.CurrentInterface;
import viettel.com.service.CurrentTempService;
import viettel.com.service.TempdayService;

@Controller
public class ApplicationController {

	/* AVG */
	@Autowired
	private TempdayService tempdayService;

	@Autowired
	@Qualifier("avgSpo2Service")
	private AvgService avgSpo2Service;

	@Autowired
	@Qualifier("avgBpService")
	private AvgService avgBpService;

	@Autowired
	@Qualifier("avgHrService")
	private AvgService avgHrService;

	/* Current */
	@Autowired
	private CurrentTempService currentTempService;

	@Autowired
	@Qualifier("CurrentSpo2Service")
	private CurrentInterface spo2Service;

	@Autowired
	@Qualifier("CurrentHrService")
	private CurrentInterface hrService;

	@Autowired
	@Qualifier("CurrentBpService")
	private CurrentInterface bpService;

	@Autowired
	@Qualifier("CurrentECGService")
	private CurrentInterface ecgService;

	public int count = 0;
	public int data[] = { 1835, 1967, 1956, 1952, 1952, 1919, 1886, 1886, 1883, 1883, 1876, 1859, 1859, 1838, 1844,
			1844, 1838, 1823, 1823, 1823, 1850, 1850, 1817, 1824, 1824, 1846, 1835, 1835, 1838, 1838, 1853, 1853, 1853,
			1853, 1862, 1862, 1858, 1872, 1872, 1876, 1874, 1874, 1883, 1896, 1896, 1911, 1911, 1910, 1913, 1913, 1906,
			1935, 1935, 1933, 1934, 1934, 1936, 1944, 1944, 1943, 1948, 1948, 1939, 1957, 1957, 1963, 1954, 1954, 1954,
			1954, 1971, 1971, 1971, 1967, 1960, 1960, 1970, 1976, 1976, 1971, 1962, 1962, 1978, 1960, 1960, 1957, 1957,
			1972, 1966, 1966, 1966, 1960, 1960, 1955, 1968, 1968, 1970, 1956, 1956, 1971, 1972, 1972, 1959, 1972, 1972,
			1991, 1978, 1978, 1967, 1967, 1966, 1979, 1979, 1973, 1968, 1968, 1979, 1977, 1977, 1960, 1970, 1970, 1975,
			1964, 1964, 1968, 1968, 1969, 1960, 1960, 1971, 1970, 1970, 1974, 1975, 1975, 1967, 1960, 1960, 1976, 1974,
			1974, 1983, 1978, 1978, 1974, 1974, 1985, 1982, 1982, 1974, 1984, 1984, 1983, 1984, 1984, 1992, 1987, 1987,
			1987, 1987, 1987, 1992, 1992, 1987, 1996, 1996, 1996, 1992, 1992, 1994, 1992, 1992, 2004, 2001, 2001, 2004,
			1998, 1998, 1991, 2005, 2005, 2022, 2022, 2005, 2007, 2007, 2011, 2012, 2012, 2008, 2016, 2016, 2021, 2024,
			2024, 2005, 2011, 2011, 2019, 2019, 2014, 2015, 2015, 2014, 1999, 1999, 2011, 2013, 2013, 1999, 2024, 2024,
			2008, 1996, 1996, 2027, 2011, 2011, 2010, 2010, 2036, 2023, 2023, 2028, 2045, 2045, 2050, 2051, 2051, 2059,
			2054, 2054, 2067, 2056, 2056, 2047, 2066, 2066, 2049, 2049, 2035, 2041, 2041, 2013, 2020, 2020, 2014, 1998,
			1998, 1990, 1992, 1992, 1987, 1980, 1980, 1979, 1985, 1985, 1980, 1980, 1981, 1992, 1992, 1974, 1987, 1987,
			1977, 1981, 1981, 1983, 1987, 1987, 2013, 2040, 2040, 2083, 2130, 2130, 2183, 2183, 2250, 2325, 2325, 2423,
			2527, 2527, 2559, 2559, 2559, 2523, 2368, 2368, 2232, 2096, 2096, 2004, 2004, 1901, 1858, 1858, 1834, 1838,
			1838, 1831, 1853, 1853, 1847, 1845, 1845, 1851, 1860, 1860, 1870, 1872, 1872, 1891, 1893, 1893, 1894, 1894,
			1901, 1919, 1919, 1917, 1930, 1930, 1947, 1925, 1925, 1943, 1952, 1952, 1947, 1954, 1954, 1951, 1951, 1960,
			1962, 1962, 1966, 1978, 1978, 1979, 1973, 1973, 1984, 1978, 1978, 1984, 1991, 1991, 1983, 1983, 1983, 1999,
			1992, 1992, 1998, 1998, 1998, 2006, 2006, 1999, 2016, 2016, 2005, 2038, 2038, 2006, 2017, 2017, 2042, 2027,
			2027, 2031, 2031, 2051, 2044, 2044, 2043, 2070, 2070, 2062, 2055, 2055, 2065, 2056, 2056, 2070, 2080, 2080,
			2068, 2078, 2078, 2077, 2077, 2074, 2087, 2087, 2093, 2102, 2102, 2091, 2102, 2102, 2118, 2114, 2114, 2116,
			2128, 2128, 2108, 2108, 2095, 2108, 2108, 2102, 2096, 2096, 2094, 2081, 2081, 2074, 2082, 2082, 2088, 2059,
			2059, 2058, 2050, 2050, 2027, 2027, 2014, 2009, 2009, 1991, 1981, 1981, 1951, 1949, 1949, 1932, 1918, 1918,
			1923, 1893, 1893, 1885, 1885, 1894, 1882, 1882, 1871, 1890, 1890, 1865, 1868, 1868, 1874, 1876, 1876, 1887,
			1884, 1884, 1886, 1888, 1888, 1895, 1902, 1902, 1898, 1898, 1898, 1906, 1906, 1911, 1914, 1914, 1918, 1922,
			1922, 1918, 1936, 1936, 1950, 1937, 1937, 1944, 1944, 1955, 1947, 1947, 1951, 1984, 1984, 1950, 1972, 1972,
			1974, 1958, 1958, 1982, 1971, 1971, 1983, 1974, 1974, 1967, 1986, 1986, 1979, 1979, 1970, 1986, 1986, 1966,
			1955, 1955, 1970, 1976, 1976, 1972, 1968, 1968, 1970, 1969, 1969, 1967, 1967, 1998, 1976, 1976, 1981, 1994,
			1994, 1982, 1987, 1987, 1987, 1996, 1996, 1983, 1974, 1974, 1991, 1991, 1982, 1984, 1984, 2004, 1982, 1982,
			1983, 2009, 2009, 1995, 1991, 1991, 2001, 2000, 2000, 1991, 1999, 1999, 2002, 1988, 1988, 1999, 1999, 1979,
			2006, 2006, 2005, 1983, 1983, 1995, 1986, 1986, 1992, 2010, 2010, 1993, 2000, 2000, 1994, 1994, 1990, 2012,
			2012, 1989, 1993, 1993, 1993, 1986, 1986, 1999, 1986, 1986, 2002, 1995, 1995, 1995, 1993, 1993, 2000, 2000,
			1996, 1997, 1997, 1995, 1998, 1998, 1983, 1997, 1997, 1998, 1990, 1990, 1993, 1996, 1996, 1982, 1995, 1995,
			2003, 2003, 2003, 1996, 1996, 1993, 1989, 1989, 2007, 2008, 2008, 2006, 2004, 2004, 1997, 2000, 2000, 2012,
			2007, 2007, 2013, 2013, 2010, 2004, 2004, 2010, 2011, 2011, 2011, 2015, 2015, 2015, 2016, 2016, 2011, 2005,
			2005, 2014, 2014, 2008, 1998, 1998, 2021, 2009, 2009, 2007, 2018, 1835, 1967, 1956, 1952, 1952, 1919, 1886,
			1886, 1883, 1883, 1876, 1859, 1859, 1838, 1844, 1844, 1838, 1823, 1823, 1823, 1850, 1850, 1817, 1824, 1824,
			1846, 1835, 1835, 1838, 1838, 1853, 1853, 1853, 1853, 1862, 1862, 1858, 1872, 1872, 1876, 1874, 1874, 1883,
			1896, 1896, 1911, 1911, 1910, 1913, 1913, 1906, 1935, 1935, 1933, 1934, 1934, 1936, 1944, 1944, 1943, 1948,
			1948, 1939, 1957, 1957, 1963, 1954, 1954, 1954, 1954, 1971, 1971, 1971, 1967, 1960, 1960, 1970, 1976, 1976,
			1971, 1962, 1962, 1978, 1960, 1960, 1957, 1957, 1972, 1966, 1966, 1966, 1960, 1960, 1955, 1968, 1968, 1970,
			1956, 1956, 1971, 1972, 1972, 1959, 1972, 1972, 1991, 1978, 1978, 1967, 1967, 1966, 1979, 1979, 1973, 1968,
			1968, 1979, 1977, 1977, 1960, 1970, 1970, 1975, 1964, 1964, 1968, 1968, 1969, 1960, 1960, 1971, 1970, 1970,
			1974, 1975, 1975, 1967, 1960, 1960, 1976, 1974, 1974, 1983, 1978, 1978, 1974, 1974, 1985, 1982, 1982, 1974,
			1984, 1984, 1983, 1984, 1984, 1992, 1987, 1987, 1987, 1987, 1987, 1992, 1992, 1987, 1996, 1996, 1996, 1992,
			1992, 1994, 1992, 1992, 2004, 2001, 2001, 2004, 1998, 1998, 1991, 2005, 2005, 2022, 2022, 2005, 2007, 2007,
			2011, 2012, 2012, 2008, 2016, 2016, 2021, 2024, 2024, 2005, 2011, 2011, 2019, 2019, 2014, 2015, 2015, 2014,
			1999, 1999, 2011, 2013, 2013, 1999, 2024, 2024, 2008, 1996, 1996, 2027, 2011, 2011, 2010, 2010, 2036, 2023,
			2023, 2028, 2045, 2045, 2050, 2051, 2051, 2059, 2054, 2054, 2067, 2056, 2056, 2047, 2066, 2066, 2049, 2049,
			2035, 2041, 2041, 2013, 2020, 2020, 2014, 1998, 1998, 1990, 1992, 1992, 1987, 1980, 1980, 1979, 1985, 1985,
			1980, 1980, 1981, 1992, 1992, 1974, 1987, 1987, 1977, 1981, 1981, 1983, 1987, 1987, 2013, 2040, 2040, 2083,
			2130, 2130, 2183, 2183, 2250, 2325, 2325, 2423, 2527, 2527, 2559, 2559, 2559, 2523, 2368, 2368, 2232, 2096,
			2096, 2004, 2004, 1901, 1858, 1858, 1834, 1838, 1838, 1831, 1853, 1853, 1847, 1845, 1845, 1851, 1860, 1860,
			1870, 1872, 1872, 1891, 1893, 1893, 1894, 1894, 1901, 1919, 1919, 1917, 1930, 1930, 1947, 1925, 1925, 1943,
			1952, 1952, 1947, 1954, 1954, 1951, 1951, 1960, 1962, 1962, 1966, 1978, 1978, 1979, 1973, 1973, 1984, 1978,
			1978, 1984, 1991, 1991, 1983, 1983, 1983, 1999, 1992, 1992, 1998, 1998, 1998, 2006, 2006, 1999, 2016, 2016,
			2005, 2038, 2038, 2006, 2017, 2017, 2042, 2027, 2027, 2031, 2031, 2051, 2044, 2044, 2043, 2070, 2070, 2062,
			2055, 2055, 2065, 2056, 2056, 2070, 2080, 2080, 2068, 2078, 2078, 2077, 2077, 2074, 2087, 2087, 2093, 2102,
			2102, 2091, 2102, 2102, 2118, 2114, 2114, 2116, 2128, 2128, 2108, 2108, 2095, 2108, 2108, 2102, 2096, 2096,
			2094, 2081, 2081, 2074, 2082, 2082, 2088, 2059, 2059, 2058, 2050, 2050, 2027, 2027, 2014, 2009, 2009, 1991,
			1981, 1981, 1951, 1949, 1949, 1932, 1918, 1918, 1923, 1893, 1893, 1885, 1885, 1894, 1882, 1882, 1871, 1890,
			1890, 1865, 1868, 1868, 1874, 1876, 1876, 1887, 1884, 1884, 1886, 1888, 1888, 1895, 1902, 1902, 1898, 1898,
			1898, 1906, 1906, 1911, 1914, 1914, 1918, 1922, 1922, 1918, 1936, 1936, 1950, 1937, 1937, 1944, 1944, 1955,
			1947, 1947, 1951, 1984, 1984, 1950, 1972, 1972, 1974, 1958, 1958, 1982, 1971, 1971, 1983, 1974, 1974, 1967,
			1986, 1986, 1979, 1979, 1970, 1986, 1986, 1966, 1955, 1955, 1970, 1976, 1976, 1972, 1968, 1968, 1970, 1969,
			1969, 1967, 1967, 1998, 1976, 1976, 1981, 1994, 1994, 1982, 1987, 1987, 1987, 1996, 1996, 1983, 1974, 1974,
			1991, 1991, 1982, 1984, 1984, 2004, 1982, 1982, 1983, 2009, 2009, 1995, 1991, 1991, 2001, 2000, 2000, 1991,
			1999, 1999, 2002, 1988, 1988, 1999, 1999, 1979, 2006, 2006, 2005, 1983, 1983, 1995, 1986, 1986, 1992, 2010,
			2010, 1993, 2000, 2000, 1994, 1994, 1990, 2012, 2012, 1989, 1993, 1993, 1993, 1986, 1986, 1999, 1986, 1986,
			2002, 1995, 1995, 1995, 1993, 1993, 2000, 2000, 1996, 1997, 1997, 1995, 1998, 1998, 1983, 1997, 1997, 1998,
			1990, 1990, 1993, 1996, 1996, 1982, 1995, 1995, 2003, 2003, 2003, 1996, 1996, 1993, 1989, 1989, 2007, 2008,
			2008, 2006, 2004, 2004, 1997, 2000, 2000, 2012, 2007, 2007, 2013, 2013, 2010, 2004, 2004, 2010, 2011, 2011,
			2011, 2015, 2015, 2015, 2016, 2016, 2011, 2005, 2005, 2014, 2014, 2008, 1998, 1998, 2021, 2009, 2009, 2007,
			2018 };

	public ApplicationController() {
		System.out.println("ApplicationController()");
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String goHome() {
		return "/html/index.html";
	}

	@RequestMapping(value = "/api/get_current_temp/{UIID}", method = RequestMethod.GET)
	public ResponseEntity<?> getCurentTemp(@PathVariable("UIID") String UUID) {
		Object obj = currentTempService.getCurrent(UUID);
		if (obj != null)
			return ResponseEntity.ok(obj);
		else
			return ResponseEntity.ok("No data");
	}

	@RequestMapping(value = "/api/get_avg_temp/{UIID}", method = RequestMethod.GET)
	public ResponseEntity<?> getAvgTemp(@PathVariable("UIID") String UUID) {
		return ResponseEntity.ok(tempdayService.getTempatureDays(30, UUID));
	}

	@RequestMapping(value = "/api/get_ecg_point/{UIID}", method = RequestMethod.GET)
	public ResponseEntity<?> getRandomPoint(@PathVariable("UIID") String UUID) {

		List<Integer> arr = new ArrayList<Integer>();
		
		for (int i = 0; i < 1000; i++) {
			arr.add(data[count]);
			count++;
			count = (count % 1332);
		}

		EcgCurrent ecg = ecgService.getCurrent(UUID);
		if (ecg != null)
			return ResponseEntity.ok(ecg.getCurrent_value());
		else
			return ResponseEntity.ok("No data");
	}

	@RequestMapping(value = "/api/get_current_spo2/{UIID}", method = RequestMethod.GET)
	public ResponseEntity<?> getCurentSpo2(@PathVariable("UIID") String UUID) {
		Object obj = spo2Service.getCurrent(UUID);
		if (obj != null)
			return ResponseEntity.ok(obj);
		else
			return ResponseEntity.ok("No data");
	}

	@RequestMapping(value = "/api/get_current_bp/{UIID}", method = RequestMethod.GET)
	public ResponseEntity<?> getCurentBp(@PathVariable("UIID") String UUID) {
		Object obj = bpService.getCurrent(UUID);
		if (obj != null)
			return ResponseEntity.ok(obj);
		else
			return ResponseEntity.ok("No data");
	}

	@RequestMapping(value = "/api/get_current_hr/{UIID}", method = RequestMethod.GET)
	public ResponseEntity<?> getCurentHr(@PathVariable("UIID") String UUID) {
		Object obj = hrService.getCurrent(UUID);
		if (obj != null)
			return ResponseEntity.ok(obj);
		else
			return ResponseEntity.ok("No data");
	}

	@RequestMapping(value = "/api/get_avg_spo2/{UIID}", method = RequestMethod.GET)
	public ResponseEntity<?> getSpo2Avg(@PathVariable("UIID") String UUID) {
		List<Object> list = avgSpo2Service.getByDays(30, UUID);
		if (list.size() == 0)
			return ResponseEntity.ok("No data");
		else
			return ResponseEntity.ok(list);
	}

	@RequestMapping(value = "/api/get_avg_hr/{UIID}", method = RequestMethod.GET)
	public ResponseEntity<?> getHeartRateAvg(@PathVariable("UIID") String UUID) {
		List<Object> list = avgHrService.getByDays(30, UUID);
		if (list.size() == 0)
			return ResponseEntity.ok("No data");
		else
			return ResponseEntity.ok(list);
	}

	@RequestMapping(value = "/api/get_avg_bp/{UIID}", method = RequestMethod.GET)
	public ResponseEntity<?> getBloodPressureAvg(@PathVariable("UIID") String UUID) {
		List<Object> list = avgBpService.getByDays(30, UUID);
		if (list.size() == 0)
			return ResponseEntity.ok("No data");
		else
			return ResponseEntity.ok(list);
	}
}
