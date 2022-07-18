// if no users are logged in/ user logged in is not admin, redirects to homepage 
// if(!principal || principal.role !== 'Manager'){
//     window.location.href="./index.html";
// }else{
//     getUsers();
// }
let userButton = document.getElementById('data');
userButton.addEventListener('click', getUsers);

let apiUrl = 'http://localhost:8080/BankApp';
async function getUsers(){

    let response = await fetch(`${apiUrl}/users`, {
        credentials: 'include'
    });

    if(response.status == 200){
        let data = await response.json();

        populateTable(data);
    } else{
        console.log('Unable to retrieve users.')
    }
}

function populateTable(data){
    let tableBody = document.getElementById('users-tbody');

    data.forEach(user => {
        let tr = document.createElement('tr');
        let tdId = document.createElement('td');
        let tdUsername = document.createElement('td');
        let tdRole = document.createElement('td');

        tdId.innerHTML = user.id;
        tdUsername.innerHTML = user.username;
        tdRole.innerHTML = user.role.role;

        tr.append(tdId);
        tr.append(tdUsername);
        tr.append(tdRole);

        tableBody.append(tr);
    });
}

let homeButton = document.getElementById('home');
homeButton.addEventListener('click', returnHome);


function returnHome(){
    window.location.href="./manager_reim.html";
}