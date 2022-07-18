// if (!principal) { //check if current user is logged in
//     window.location.href = "./index.html";
// }
// async function reimtype() {


//     let response = await fetch(`${apiUrl}/type`, {
//         method: 'GET',
//         credentials: 'include',
//         headers: {
//             'Content-Type': 'application/x-www-form-urlencoded'
//         },

//     });
//     if (response.status == 200) {
//         let data = await response.json();

        
//         var reimType_list = data;
//         let reimSelect = document.getElementById('t_id');
//         reimSelect.innerHTML = "";
//         let opt = document.createElement('option');
//         opt.setAttribute('selected', 'selected');
//         opt.innerHTML = "Select a type";
//         reimSelect.append(opt);

//         for (i in reimType_list) {
//             let opt = document.createElement('option');
//             opt.setAttribute('value', reimType_list[i].id);
//             opt.innerHTML = reimType_list[i].reimb_type;
//             reimSelect.append(opt);
//         }
//     }
// }
// reimtype();
// Setting up event listener for add button
let addButton = document.getElementById('addButton');
addButton.addEventListener('click', add);

async function add() {
    console.log('Added');

    let amount = document.getElementById('amount').value;
    let description = document.getElementById('description').value;
    let author_id = document.getElementById('author_id').value;
    let author_username = document.getElementById('author_username').value;
    let author_password = document.getElementById('author_password').value;
    let author_firstName = document.getElementById('author_firstName').value;
    let author_lastName = document.getElementById('author_lastName').value;
    let author_email = document.getElementById('author_email').value;

    // let role_id = document.getElementById('author_role_id').value;
    // let role = document.getElementById('author_role').value;

    let submitted = document.getElementById('submitted').value;

    let tId = document.getElementById('id').value;
    let rType = document.getElementById('type').value;

    if (amount < 1 || description == '' || tId == '') {
        document.getElementById('message').innerHTML = ` Unable to add.`
        return false;
    }
    let apiUrl = 'http://localhost:8080/BankApp';

    let response = await fetch(`${apiUrl}/reimbursement`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: JSON.stringify({
            'amount': `${amount}`,
            'description': `${description}`,
            'author': {
                'id': `${author_id}`,
                'username': `${author_username}`,
                'password': `${author_password}`,
                'firstName': `${author_firstName}`,
                'lastName': `${author_lastName}`,
                'email': `${author_email}`,
            },
            // 'role': {
            //     'role_id': `${role_id}`,
            //     'role': `${role}`
            // },
            'submitted': `${submitted}`,
            'status_id': { //default to any new request to pending/3
                'id': 3,
                'status': "Pending"
            },
            't_id': {
                'id': `${tId}`,
                'reim_type': `${rType}`

            }
        })
    });

    if (response.status == 200) {
        console.log("SUCCESS!");

    } else {
        console,log("ERROR!")
    }
}