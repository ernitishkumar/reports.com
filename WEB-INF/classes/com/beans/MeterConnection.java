package com.beans;
import java.io.*;
public class MeterConnection implements Serializable{

	private String id;
	private String divisionName;
	private String locationCode;
	private String locationName;
	private String connectionName;
	private String firstAddress;
	private String secondAddress;
	private String groupNo;
	private String readerNo;
	private String connectionNo;
	private String connectionLoad;
	private String loadUnit;
	private String arrears;
	private String netBill;
	private String tariff;

	public MeterConnection() {
	}

	public MeterConnection(String id,String divisionName, String locationCode, String locationName, String connectionName, String firstAddress, String secondAddress, String groupNo, String readerNo, String connectionNo, String connectionLoad, String loadUnit, String arrears, String netBill, String tariff) {
		this.divisionName = divisionName;
		this.id = id;
		this.locationCode = locationCode;
		this.locationName = locationName;
		this.connectionName = connectionName;
		this.firstAddress = firstAddress;
		this.secondAddress = secondAddress;
		this.groupNo = groupNo;
		this.readerNo = readerNo;
		this.connectionNo = connectionNo;
		this.connectionLoad = connectionLoad;
		this.loadUnit = loadUnit;
		this.arrears = arrears;
		this.netBill = netBill;
		this.tariff = tariff;
	    this.id=id;
	    this.divisionName = divisionName;
		this.locationCode = locationCode;
		this.locationName = locationName;
		this.connectionName = connectionName;
		this.firstAddress = firstAddress;
		this.secondAddress = secondAddress;
		this.groupNo = groupNo;
		this.readerNo = readerNo;
		this.connectionNo = connectionNo;
		this.connectionLoad = connectionLoad;
		this.loadUnit = loadUnit;
		this.arrears = arrears;
		this.netBill = netBill;
		this.tariff = tariff;
	}

	public MeterConnection(String divisionName, String locationCode, String locationName, String connectionName, String firstAddress, String secondAddress, String groupNo, String readerNo, String connectionNo, String connectionLoad, String loadUnit, String arrears, String netBill, String tariff) {
		this.divisionName = divisionName;
		this.locationCode = locationCode;
		this.locationName = locationName;
		this.connectionName = connectionName;
		this.firstAddress = firstAddress;
		this.secondAddress = secondAddress;
		this.groupNo = groupNo;
		this.readerNo = readerNo;
		this.connectionNo = connectionNo;
		this.connectionLoad = connectionLoad;
		this.loadUnit = loadUnit;
		this.arrears = arrears;
		this.netBill = netBill;
		this.tariff = tariff;
	}

	private void setId(String id){
		this.id=id;

	}

	public String getId() {
		return id;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getConnectionName() {
		return connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	public String getFirstAddress() {
		return firstAddress;
	}

	public void setFirstAddress(String firstAddress) {
		this.firstAddress = firstAddress;
	}

	public String getSecondAddress() {
		return secondAddress;
	}

	public void setSecondAddress(String secondAddress) {
		this.secondAddress = secondAddress;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public String getReaderNo() {
		return readerNo;
	}

	public void setReaderNo(String readerNo) {
		this.readerNo = readerNo;
	}

	public String getConnectionNo() {
		return connectionNo;
	}

	public void setConnectionNo(String connectionNo) {
		this.connectionNo = connectionNo;
	}

	public String getConnectionLoad() {
		return connectionLoad;
	}

	public void setConnectionLoad(String connectionLoad) {
		this.connectionLoad = connectionLoad;
	}

	public String getLoadUnit() {
		return loadUnit;
	}

	public void setLoadUnit(String loadUnit) {
		this.loadUnit = loadUnit;
	}

	public String getArrears() {
		return arrears;
	}

	public void setArrears(String arrears) {
		this.arrears = arrears;
	}

	public String getNetBill() {
		return netBill;
	}

	public void setNetBill(String netBill) {
		this.netBill = netBill;
	}

	public String getTariff() {
		return tariff;
	}

	public void setTariff(String tariff) {
		this.tariff = tariff;
	}

}