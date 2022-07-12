let submitReimbursementButton = document.getElementById('submitButton');
submitReimbursementButton.addEventListener('click', submitReimbursement);

let data = sessionStorage.getItem('principal');
let userData = JSON.parse(data);

async function submitReimbursement(){
    let rAmount = document.getElementById('reimbursementAmount').value;
    let rt = document.getElementById('reimbursementType').value;
    let rType;

    if(rt == 'lodging') {
        rType = 1;
    } else if (rt == 'travel') {
        rType = 2;
    } else if (rt == 'food'){
        rType = 3;
    } else {
        rType = 4;
    }

    let description = document.getElementById('description').value;
    userId = userData.id;

    let response = await fetch(`${apiUrl}/employee`,{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            'reimbursementTypeId': `${rType}`,
            'reimbursementAmount': `${rAmount}`,
            'reimbursementDescription': `${description}`,
            'reimbursmentAuthor': `${userId}`,
            'reimbursementResolver': `${1}`,
            'reimbursementStatusId': `${1}`
        })
    })
    if(response.status == 201) {
        window.location.href="./index.html";
    }
}