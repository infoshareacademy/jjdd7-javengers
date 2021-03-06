google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(drawChart);



function drawChart() {

    // let dataset1 = [
    //   {"month": "January", "quantity": 4},
    //   {"month": "February", "quantity": 5},
    //   {"month": "March", "quantity": 5},
    //   {"month": "April", "quantity": 7},
    //   {"month": "May", "quantity": 15},
    //   {"month": "June", "quantity": 20},
    //   {"month": "July", "quantity": 35},
    //   {"month": "August", "quantity": 40},
    //   {"month": "October", "quantity": 10},
    //   {"month": "November", "quantity": 5},
    //   {"month": "December", "quantity": 10}
    // ];
    $.getJSON('/api/admin/statistics/monthvacation', function(dataset1) {

        let monthsAndQuantitiesArrayChart1 = [['Month', 'Quantity',],];

        for (let i = 0; i < dataset1.length; i++) {
            let pairMonthQuantity = dataset1[i];
            let monthAndQuantityArray = [pairMonthQuantity.month,
                pairMonthQuantity.quantity];
            monthsAndQuantitiesArrayChart1.push(monthAndQuantityArray);
        }

        let dataChart1 = google.visualization.arrayToDataTable(
            monthsAndQuantitiesArrayChart1);

        const optionsChart1 = {
            title: 'Months Vacation Rank'
        };

        let chart1 = new google.visualization.PieChart(
            document.getElementById('piechart1'));

        chart1.draw(dataChart1, optionsChart1);
    });

    $.getJSON('/api/admin/statistics/employeevacation', function(dataset2) {

        // let dataset2 = [
        //   {"fullName": "Marek Sitarski", "quantity": 8},
        //   {"fullName": "Arek Lewandowski", "quantity": 6},
        //   {"fullName": "Wiesław Niedzielan", "quantity": 3},
        //   {"fullName": "Jurek Dawidziuk", "quantity": 2},
        //   {"fullName": "Marek Wieckiewicz", "quantity": 1}
        // ];

        let fullNameAndQuantitiesArrayChart2 = [['Full name', 'Quantity',],];

        for (let i = 0; i < dataset2.length; i++) {
            let pairFullNameQuantity = dataset2[i];
            let fullNameAndQuantityArray = [pairFullNameQuantity.fullName,
                pairFullNameQuantity.quantity];
            fullNameAndQuantitiesArrayChart2.push(fullNameAndQuantityArray);
        }

        let dataChart2 = google.visualization.arrayToDataTable(
            fullNameAndQuantitiesArrayChart2);

        const optionsChart2 = {
            title: 'Employee Vacation Rank',
            legend: {position: "none"}
        };

        let chart2 = new google.visualization.BarChart(
            document.getElementById('barchart2'));

        chart2.draw(dataChart2, optionsChart2);

    });

    $.getJSON('/api/admin/statistics/statusvacation', function(dataset3) {

        // let dataset3 = [
        //   {"status": "accepted", "quantity": 4},
        //   {"status": "refused", "quantity": 5}
        // ];

        let statusesAndQuantitiesArrayChart3 = [['Status', 'Quantity',],];

        for (let i = 0; i < dataset3.length; i++) {
            let pairStatusQuantity = dataset3[i];
            let statusAndQuantityArray = [pairStatusQuantity.status,
                pairStatusQuantity.quantity];
            statusesAndQuantitiesArrayChart3.push(statusAndQuantityArray);
        }

        let dataChart3 = google.visualization.arrayToDataTable(
            statusesAndQuantitiesArrayChart3);

        const optionsChart3 = {
            title: 'Accepted/Refused Vacations'
        };

        let chart3 = new google.visualization.PieChart(
            document.getElementById('piechart3'));

        chart3.draw(dataChart3, optionsChart3);

    });

    $.getJSON('/api/admin/statistics/teamvacation', function(dataset4) {

        // let dataset4 = [
        //   {"teamName": "GitLoopersi", "quantity": 45,},
        //   {"teamName": "Javengersi", "quantity": 24},
        //   {"teamName": "Wojownicy Klawiatury", "quantity": 17},
        //   {"teamName": "Zajavieni", "quantity": 5}
        // ];

        let teamNamesAndQuantitiesArrayChart4 = [['Team name', 'Quantity',
            {role: 'style'}],];

        for (let i = 0; i < dataset4.length; i++) {
            let pairTeamNameQuantity = dataset4[i];
            let teamNameAndQuantityArray = [pairTeamNameQuantity.teamName,
                pairTeamNameQuantity.quantity,
                'color: #' + Math.floor(Math.random() * 16777215).toString(16)];
            teamNamesAndQuantitiesArrayChart4.push(teamNameAndQuantityArray);
        }

        let dataChart4 = google.visualization.arrayToDataTable(
            teamNamesAndQuantitiesArrayChart4);

        const optionsChart4 = {
            title: 'Team Vacation Rank',
            legend: {position: "none"}
        };

        let chart4 = new google.visualization.ColumnChart(
            document.getElementById('columnchart4'));

        chart4.draw(dataChart4, optionsChart4);

    });
}