package com.example.covid19tracler;

public class CoronaItem {

    private int localNewCases;
    private int localActiveCases;
    private int localTotalCases;
    private int localDeaths;
    private int localRecovered;
    private int totalIndividuals;
    private int todayDeaths;

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    private int globalNewCases;
    private int globalTotalCases;
    private int globalDeaths;
    private int globalNewDeaths;
    private int globalRecovered;

    public int getLocalNewCases() {
        return localNewCases;
    }

    public void setLocalNewCases(int localNewCases) {
        this.localNewCases = localNewCases;
    }

    public int getLocalActiveCases() {
        return localActiveCases;
    }

    public void setLocalActiveCases(int localActiveCases) {
        this.localActiveCases = localActiveCases;
    }

    public int getLocalTotalCases() {
        return localTotalCases;
    }

    public void setLocalTotalCases(int localTotalCases) {
        this.localTotalCases = localTotalCases;
    }

    public int getLocalDeaths() {
        return localDeaths;
    }

    public void setLocalDeaths(int localDeaths) {
        this.localDeaths = localDeaths;
    }

    public int getLocalRecovered() {
        return localRecovered;
    }

    public void setLocalRecovered(int localRecovered) {
        this.localRecovered = localRecovered;
    }

    public int getTotalIndividuals() {
        return totalIndividuals;
    }

    public void setTotalIndividuals(int totalIndividuals) {
        this.totalIndividuals = totalIndividuals;
    }

    public int getGlobalNewCases() {
        return globalNewCases;
    }

    public void setGlobalNewCases(int globalNewCases) {
        this.globalNewCases = globalNewCases;
    }

    public int getGlobalTotalCases() {
        return globalTotalCases;
    }

    public void setGlobalTotalCases(int globalTotalCases) {
        this.globalTotalCases = globalTotalCases;
    }

    public int getGlobalDeaths() {
        return globalDeaths;
    }

    public void setGlobalDeaths(int globalDeaths) {
        this.globalDeaths = globalDeaths;
    }

    public int getGlobalNewDeaths() {
        return globalNewDeaths;
    }

    public void setGlobalNewDeaths(int globalNewDeaths) {
        this.globalNewDeaths = globalNewDeaths;
    }

    public int getGlobalRecovered() {
        return globalRecovered;
    }

    public void setGlobalRecovered(int globalRecovered) {
        this.globalRecovered = globalRecovered;
    }

    public CoronaItem(int localNewCases, int localActiveCases, int localTotalCases, int localDeaths, int localRecovered, int totalIndividuals, int todayDeaths, int globalNewCases, int globalTotalCases, int globalDeaths, int globalNewDeaths, int globalRecovered) {
        this.localNewCases = localNewCases;
        this.localActiveCases = localActiveCases;
        this.localTotalCases = localTotalCases;
        this.localDeaths = localDeaths;
        this.localRecovered = localRecovered;
        this.totalIndividuals = totalIndividuals;
        this.todayDeaths = todayDeaths;
        this.globalNewCases = globalNewCases;
        this.globalTotalCases = globalTotalCases;
        this.globalDeaths = globalDeaths;
        this.globalNewDeaths = globalNewDeaths;
        this.globalRecovered = globalRecovered;
    }
}
