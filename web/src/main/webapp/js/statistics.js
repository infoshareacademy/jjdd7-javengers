google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {

  $.getJSON('/api/superHero/statistics/categoryRank', function (dataset1) {
    let categoriesAndQuantitiesArrayChart1 = [['Category Name', 'Quantity',],];

    for (let i = 0; i < dataset1.length; i++) {
      let pairCategoryQuantity = dataset1[i];
      let categoryAndQuantityArray = [pairCategoryQuantity.categoryName,
        pairCategoryQuantity.quantity];
      categoriesAndQuantitiesArrayChart1.push(categoryAndQuantityArray);
    }

    let dataChart1 = google.visualization.arrayToDataTable(
        categoriesAndQuantitiesArrayChart1);

    var optionsChart1 = {
      'title': 'Categories Ranking',
      is3D: true
    };

    let chart1 = new google.visualization.PieChart(
        document.getElementById('piechart1'));

    chart1.draw(dataChart1, optionsChart1);
  });

  $.getJSON('/api/superHero/statistics/topTen', function (dataset2) {

    let fullNameAndQuantitiesArrayChart2 = [['Recipie Name', 'Quantity',],];

    for (let i = 0; i < dataset2.length; i++) {
      let pairFullNameQuantity = dataset2[i];
      let fullNameAndQuantityArray = [pairFullNameQuantity.recipieName,
        pairFullNameQuantity.quantity];
      fullNameAndQuantitiesArrayChart2.push(fullNameAndQuantityArray);
    }

    let dataChart2 = google.visualization.arrayToDataTable(
        fullNameAndQuantitiesArrayChart2);

    var optionsChart2 = {
      title: 'TOP 10 Recipies',
      is3D: true,
      legend: {position: "none"}
    };

    let chart2 = new google.visualization.BarChart(
        document.getElementById('barchart2'));

    chart2.draw(dataChart2, optionsChart2);
  });

/*    let dataset4 = [
      {"recipieName": "mojito", "quantity": 45},
      {"recipieName": "margarita", "quantity": 24},
      {"recipieName": "cuba libra", "quantity": 17},
      {"recipieName": "jamaica kiss", "quantity": 5}
    ];*/

  $.getJSON('/api/superHero/statistics/recipeCategoryRank', function (dataset3) {
    let recipeNamesAndQuantitiesArrayChart4 = [['Category Name', 'Quantity',
      {role: 'style'}],];

    for (let i = 0; i < dataset3.length; i++) {
      let pairRecipeNameQuantity = dataset3[i];
      let recipeNameAndQuantityArray = [pairRecipeNameQuantity.categoryName,
        pairRecipeNameQuantity.quantity,
        'color: #' + Math.floor(Math.random() * 16777215).toString(16)];
      recipeNamesAndQuantitiesArrayChart4.push(recipeNameAndQuantityArray);
    }

    let dataChart4 = google.visualization.arrayToDataTable(
        recipeNamesAndQuantitiesArrayChart4);

    var optionsChart4 = {
      'title': 'Recipe per Categories Rank',
      is3D: true,
      legend: {position: "none"}
    };

    let chart4 = new google.visualization.ColumnChart(
        document.getElementById('columnchart4'));

    chart4.draw(dataChart4, optionsChart4);
  });
}