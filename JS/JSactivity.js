document.getElementById('getData').addEventListener("click", getData);

let baseApiURL = 'https://pokeapi.co/api/v2/pokemon';

async function getData(){
    console.log('You have hit enter!');
    
    let id = document.getElementById('dataInput').value;
    console.log(`id = ${id}`);

    let httpResponse = await fetch(`${baseApiURL}/${id}`);

    if(httpResponse.status >= 200 && httpResponse.status < 300){
    let data = await httpResponse.json();

    populateData(data);
    
    } else {
        console.log('Invalid request.');
    }
}

function populateData(response){
    console.log(response);
    

    let ptable = document.getElementById('data');
    let rows = 2;
    let cols = 3;
    //pokemon name, height, and weight in our table
    for(var i = 0; i < rows; i++){
        var pd;
        pd = document.createElement('tr');
        for(var j = 0; j < cols; j++){
            var td;
            if(i==0){ td = document.createElement('th');
            if(j==0) td.innerHTML = 'name';
            else if(j == 1)
                td.innerHTML = 'height';
             else
                td.innerHTML = 'weight';
            
        } else{
            td = document.createElement('td');
            if(j==0) td.innerHTML = response.name;
            else if(j==1) td.innerHTML = response.height;
            else td.innerHTML = response.weight;
        }
        ptable.appendChild(td);
    }
    data.appendChild(pd);
}
data.appendChild(ptable);

}