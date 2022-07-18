let showButton = document.getElementById('Show');
showButton.addEventListener('click', getReims);

let newButton = document.getElementById('Create');
newButton.addEventListener('click', newR);

// if (!principal) {
//     window.location.href = "./index.html";
// }

// if (principal.role === 'Employee') {
//     document.getElementById('newReimbButton').style.visibility = 'visible';
//     document.getElementById('newReimbButton').style.display = 'inline';
// } else {
//     document.getElementById('newReimbButton').style.visibility = 'hidden';
//     document.getElementById('newReimbButton').style.display = 'none';
// }

function newR(){
    window.location.href="./new_reim.html";
}

async function getReims() {
    console.log("Reimbursements:");
    let reimbRes = await fetch(`${apiUrl}/reimbursement`, {
        // method: 'GET',
        // headers: {
        // 'Content-Type': 'application/x-www-form-urlencoded'}
    // method: 'GET',
    // credentials: 'include',
    // headers: {
    //     'Content-Type': 'application/x-www-form-urlencoded'
    // },
    });

    if (reimbRes.status == 200) {
        let reimb = await reimbRes.json();
        console.log('Reims:');
        popReim(reimb);
    } else {
        console.log('Unable to fetch data.');
    }
}

function popReim(reimb){
    let tableR = document.getElementById('reim_body');
    // let data;

    // console.log('ReimbPop');
    reimb.forEach(element => {
        let tr = document.createElement('tr');

        let rowId = document.createElement('td');
        let rowAmount = document.createElement('td');
        let rowDescription = document.createElement('td');
        let rowSubmitted = document.createElement('td');
        let rowResolved = document.createElement('td');
        let rowResolver = document.createElement('td');
        let rowAuthor = document.createElement('td');
        let rowStatus = document.createElement('td');
        let rowType = document.createElement('td');

        let approve = document.createElement('td');
        let deny = document.createElement('td');
        approve.innerHTML = "<button type='button' id='accept'>Approve</button>";
        deny.innerHTML = "<button type='button' id='reject'>Deny</button>";

        rowId.innerHTML = element.id;
        rowAmount.innerHTML = element.amount;
        rowDescription.innerHTML = element.description;
        rowSubmitted.innerHTML = element.submitted;
        rowResolved.innerHTML = element.resolved;
        rowResolver.innerHTML = element.resolver.id;
        rowAuthor.innerHTML = element.author.id;
        rowStatus.innerHTML = element.reim_status.status;
        rowType.innerHTML = element.reim_type.reim_type;

        tr.append(rowId);
        tr.append(rowAmount);
        tr.append(rowDescription);
        tr.append(rowSubmitted);
        tr.append(rowResolved);
        tr.append(rowResolver);
        tr.append(rowAuthor);
        tr.append(rowStatus);
        tr.append(rowType);

        tr.append(approve);
        tr.append(deny);

        tableR.append(tr);
    });
}

let approveButton = document.getElementById('accept');
approveButton.addEventListener('click', approve);

let denyButton = document.getElementById('reject');
denyButton.addEventListener('click', deny);

async function approve(){
    console.log('Approved');
    // let newId = document.getElementById('rowId').value;
    // let newStatus = document.getElementById('rowStatus').value;
    const reim_status = {
        'id' : `${rowId}`,
        'status' : `${rowStatus}`
    }

    let response = await fetch(`${apiUrl}/reimbursement/${rowId}`, {
        method: 'PUT',
        body: JSON.stringify(reim_status)
        });

        if(response.status = 200){
            // let data = await response.json();
            // sessionStorage.setItem('principal', JSON.stringify(data));
            console.log('Success');
        } else{
            console.log('Unsuccessful')
        }
    }

async function deny(){
    console.log('Denied');
    const reim_status = {
        'id' : `${rowId}`,
        'status' : `${rowStatus}`
    }

    let response = await fetch(`${apiUrl}/reimbursement/${rowId}`,{
        method: 'PUT',
        body: JSON.stringify(reim_status)
    })
    if(response.status == 202){
        console.log('Updated')
    } else{
        console.log('Error');
    }
}