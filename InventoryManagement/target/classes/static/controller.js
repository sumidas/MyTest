/**
 * Created by sumi on 2/8/16.
 */

//Inventory Master Controller

app1.controller('inController', function($scope, $http, $state){

    var url = "http://localhost:8080/display";
    $http({
        url: url,
        method: 'POST'
    }).success(function(response)
    {
        $scope.dropdown= response;
    });

    $scope.table = {
        item: [],
        quantity: []
    };

    $scope.addFormItems = function() {
        if ($scope.table.item.length < $scope.dropdown.length)
        {
            $scope.table.item.push('');
            $scope.table.quantity.push('');
        }
    };

    $scope.deleteFormItems = function() {
        if($scope.table.item.length>1)
        {
            $scope.table.item.pop();
            $scope.table.quantity.pop();
        }

    };

    $scope.reset= function()
    {
        $scope.table.item=[];
        $scope.table.quantity=[];
        $scope.table.item.push('');
        $scope.table.quantity.push('');
    }

    $scope.reset1= function()
    {
        $scope.invenName="";
        $scope.unitMeasure="";
        $scope.cost="";
        $scope.openBalance="";
        $scope.currBalance="";
        $scope.dimension="";
    }

    $scope.submitItemTable = function() {
        var f=0;
        if ($scope.table.item.length<1)
            $scope.inOutput= "Item and Quantity Required!!!";
        else
        {
            for(var i=0; i< $scope.table.item.length; i++)
            {
                if($scope.table.item[i]== null || $scope.table.item[i]== "" ||
                    $scope.table.quantity[i]== null || $scope.table.quantity[i]== "")
                {
                    f=1;
                    $scope.inOutput="Please Fill all the Fields!!!";
                    break;
                }
            }

            if (f==0)
            {
                console.log($scope.table);
                var url="http://localhost:8080/itemTableEntry";
                console.log("fine");
                $http({
                    url: url,
                    method: 'POST',
                    data: $scope.table
                }).success(function (response) {
                    console.log("ok");
                    if (response.id === undefined)
                    {
                        $scope.inOutput = "Error: Purchase Order not sent!!";
                    }
                    else {
                        $scope.inOutput = "Your Purchase Order has sent to Purchase Department";
                    }
                });
            }
        }
    };

    $scope.entry = function(){
        var name = $scope.invenName;
        var measure = $scope.unitMeasure;
        var cost = $scope.cost;
        var ob = $scope.openBalance;
        var cb= $scope.currBalance;
        var dim= $scope.dimension;

        if(name==undefined || measure== undefined || cost== undefined || ob==undefined ||
           cb== undefined || dim == undefined)
        {

        }
        else
        {
            var url="http://localhost:8080/entry?name="+name + "&measure="+measure +"&cost="+cost+
                "&ob="+ob + "&cb="+cb + "&dim="+dim;
            $http.get(url).success(function(response)
            {
                if (response.invenID==undefined)
                {
                    $scope.output = "Error: Item already Exists in Inventory!!!";
                    //console.log("Inside 2");
                }
                else
                {
                    console.log("Inside 3");
                    $scope.output = "Item Inserted Successfully";
                }
            });
        }
    }

    $scope.delete = function()
    {
        var name= $scope.delName;

        if(name==undefined)
        {

        }
        else
        {
            var url= "http://localhost:8080/delete?name=" +name;
            $http.get(url).success(function(response)
            {
                $scope.delName="";
                if (response.invenID==undefined)
                {
                    $scope.x = "Error: No such Item exist in Inventory!!!";
                    // console.log("Inside 2");
                }
                else
                {
                    $scope.x= "Item Deleted Successfully";
                }
            });
        }

    }

    $scope.display = function()
    {
        var url = "http://localhost:8080/display";
        $http({
            url: url,
            method: 'POST'
        }).success(function(response)
        {
            $scope.output1= response;
        });
    }

});


//Production Controller

app1.controller('proController', function($scope, $http, $state){
    var u= "http://localhost:8080/display";
    $http({
        url: u,
        method: 'POST'
    }).success(function(response)
    {
        $scope.dropdown= response;
    });

    $scope.table = {
        item: [],
        quantity: []
    };

    $scope.addFormItems = function() {
        if ($scope.table.item.length < $scope.dropdown.length)
        {
            $scope.table.item.push('');
            $scope.table.quantity.push('');
        }

    };

    $scope.deleteFormItems = function() {
        if($scope.table.item.length>1)
        {
            $scope.table.item.pop();
            $scope.table.quantity.pop();
        }
    };

    $scope.reset= function()
    {
        $scope.table.item=[];
        $scope.table.quantity=[];
        $scope.table.proName="";
        $scope.table.total="";
        $scope.table.item.push('');
        $scope.table.quantity.push('');
    }

    $scope.submitTable = function() {

        var f=0;
        if ($scope.table.item.length<1 || $scope.table.proName== undefined || $scope.table.total== undefined)
            $scope.proOutput= "All Fields Required!!!";
        else
        {
            for(var i=0; i< $scope.table.item.length; i++)
            {
                if($scope.table.item[i]== null || $scope.table.item[i]== "" ||
                    $scope.table.quantity[i]== null || $scope.table.quantity[i]== "")
                {
                    f=1;
                    $scope.proOutput="Please Fill all the Fields!!!";
                    break;
                }
            }
            if (f==0)
            {
                console.log($scope.table);
                var url="http://localhost:8080/proEntry";
                console.log("fine");
                $http({
                    url: url,
                    method: 'POST',
                    data: $scope.table
                }).success(function (response) {
                    console.log("ok");
                    if (response.proId === undefined)
                    {
                        $scope.proOutput = "Error: Product Not Manufactured!!! Insufficient Raw Material Quantity!!! Demand has been sent";
                    }
                    else {
                        $scope.proOutput = "Production of Item is Successful";
                    }
                });
            }
        }
    };

    $scope.proDisplay = function()
    {
        var url = "http://localhost:8080/proDisplay";

        $http({
            url: url,
            method: 'POST'
        }).success(function(response){
            $scope.output=response;
        });
    }


});

//Purchase Controller

app1.controller('purController', function($scope, $http, $state){

    var u= "http://localhost:8080/getContent";

    $http({
        url: u,
        method: 'POST'
    }).success(function(response)
    {
        $scope.dropdown= response;
    });

    $scope.table = {
        item: [],
        quantity: [],
        cost1 : []
    };
    $scope.addFormItems = function() {
        console.log($scope.table.item.length + " " + $scope.dropdown.length)
        if($scope.table.item.length< $scope.dropdown.length)
        {
            $scope.table.item.push('');
            $scope.table.quantity.push('');
            $scope.table.cost1.push('');
        }
    }

    $scope.deleteFormItems = function(){
        if ($scope.table.item.length>1)
        {
            $scope.table.item.pop();
            $scope.table.quantity.pop();
            $scope.table.cost1.pop();
        }
    }
    $scope.reset= function()
    {
        $scope.table.item=[];
        $scope.table.quantity=[];
        $scope.table.cost1=[];
        $scope.table.vendorName="";
        $scope.table.tax="";
        $scope.table.item.push('');
        $scope.table.quantity.push('');
        $scope.table.cost1.push('');
    }

    $scope.getContent= function()
    {
        var u= "http://localhost:8080/getContent";

        $http({
            url: u,
            method: 'POST'
        }).success(function(response)
        {
            $scope.dropdown= response;
        });
    }

    $scope.submitPurTable = function() {

        var f=0;
        if ($scope.table.item.length<1 || $scope.table.vendorName==undefined || $scope.table.tax==undefined)
            $scope.purOutput="All Fields Required!!!"
        else
        {
            for(var i=0; i< $scope.table.item.length; i++)
            {
                if($scope.table.item[i]== null || $scope.table.item[i]== "" ||
                    $scope.table.quantity[i]== null || $scope.table.quantity[i]== "" ||
                    $scope.table.cost1[i]==null || $scope.table.cost1[i]=="")
                {
                    f=1;
                    $scope.purOutput="Please Fill all the Fields!!!";
                    break;
                }
            }
            if (f==0)
            {
                console.log($scope.table);
                var url="http://localhost:8080/purEntry";
                console.log("fine");
                $http({
                    url: url,
                    method: 'POST',
                    data: $scope.table
                }).success(function (response) {
                    console.log("ok");
                    if (response.purId == undefined)
                        $scope.purOutput = "Error: Product Not Purchased";
                    else {
                        console.log("successful");
                        $scope.purOutput = "Product Successfully Purchased";
                    }
                });

            }
        }
    }

    $scope.purDisplay = function()
    {
        var url = "http://localhost:8080/purDisplay";

        $http({
            url: url,
            method: 'POST'
        }).success(function(response)
        {
            $scope.output= response;

            var tc= 0, nc=0;
            for (var i=0; i<$scope.output.length; i++)
            {
                tc=0;
                $scope.test= $scope.output[i].purItemList;
                   for(x=0;x<$scope.test.length;x++)
                   {
                       tc=tc+ ($scope.test[x].purItemCost * $scope.test[x].purItemQuan);
                       console.log($scope.test[x].purItemCost);
                   }
                nc= tc + ((tc*15)/100);
                $scope.totalCost =tc;
                $scope.netCost = nc;
                $scope.output[i].totalCost= tc;
                $scope.output[i].netCost = nc;
                console.log($scope.output[i].totalCost + " " + $scope.output[i].netCost);
            }
        });

    }


});