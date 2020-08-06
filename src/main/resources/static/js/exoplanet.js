"use strict";

let myData;

const exoplanets = fetch('https://exoplanetarchive.ipac.caltech.edu/cgi-bin/nstedAPI/nph-nstedAPI?table=exoplanets&select=pl_name,pl_disc,pl_discmethod,pl_facility,pl_hostname&format=json')
    .then(response => response.json())
    .then(response => {

        myData = response;
        getList(getYears(response).sort(), "years");
        getList(getMethod(response).sort(), "method");
        getList(getFacs(response).sort(), "facilities");
        getList(getHost(response).sort(), "host");

    })
    .catch(error => console.error(error));

// ***** function to post data to the table post query
function postData(arr) {
    $(".toAdd").empty();
    for (let i = 0; i < arr.length; i++) {
        $(".toAdd").append("<tr>" +
            "<td>" + arr[i].pl_disc + "</td>" +
            "<td>" + arr[i].pl_facility + "</td>" +
            "<td>" + arr[i].pl_discmethod + "</td>" +
            "<td>" + arr[i].pl_name + "</td>" +
            "<tr/>");
    }
}

// ***** function to get unique values posted to the select dropdown
function getList(arr, str) {
    $("#" + str).append('<option value="" selected> ... </option>');
    for (let i = 0; i < arr.length; i++) {
        $("#" + str).append('<option value="' + arr[i].toString() + '">' + arr[i].toString() + '</option>');
    }
}

// ***** function to get unique list of years discovered
function getYears(arr) {
    let bucket = [];
    for (let i = 0; i < arr.length; i++) {
        bucket.push(arr[i].pl_disc);
    }
    return [...new Set(bucket)];
}

// ***** function to get unique list of facilities
function getFacs(arr) {
    let bucket = [];
    for (let i = 0; i < arr.length; i++) {
        bucket.push(arr[i].pl_facility);
    }
    return [...new Set(bucket)];
}

// ***** function to get unique list of methods of discovery
function getMethod(arr) {
    let bucket = [];
    for (let i = 0; i < arr.length; i++) {
        bucket.push(arr[i].pl_discmethod);
    }
    return [...new Set(bucket)];
}

// ***** function to get unique list of hosts
function getHost(arr) {
    let bucket = [];
    for (let i = 0; i < arr.length; i++) {
        bucket.push(arr[i].pl_hostname);
    }
    return [...new Set(bucket)];
}

// ***** function to refine the list of results based on query criteria
function refine(arr1, arr2) {
    let bucket;

    let str1 = arr2[0];
    let str2 = arr2[1];
    let str3 = arr2[2];
    let str4 = arr2[3];

    bucket = arr1.filter(function (a) {
        return a.pl_disc.toString().includes(str1) &&
            a.pl_facility.includes(str2) &&
            a.pl_discmethod.includes(str3) &&
            a.pl_hostname.includes(str4);
    })
    return bucket;
}

// ***** function to compile a query criteria list from the select dropdown "year disc, facility, etc."
function getCriteria() {
    let criteria = [];
    let crit1 = $("#years").val();
    let crit2 = $("#facilities").val();
    let crit3 = $("#method").val();
    let crit4 = $("#host").val();
    criteria.push(crit1, crit2, crit3, crit4);
    return criteria;
}

// ***** function to execute the refine function (aka. "event listener")
function search() {

}

// ***** function to clear the query pane
function clearQueryFields() {
    $("#years").val("...")
    $("#facilities").val("...")
    $("#method").val("...")
    $("#host").val("...")
}