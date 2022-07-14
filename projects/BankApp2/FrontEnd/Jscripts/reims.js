if (!principal) {
    window.location.href = "./index.html";
}

if (principal.role === 'Employee') {
    document.getElementById('newReimbButton').style.visibility = 'visible';
    document.getElementById('newReimbButton').style.display = 'inline';
} else {
    document.getElementById('newReimbButton').style.visibility = 'hidden';
    document.getElementById('newReimbButton').style.display = 'none';
}

async function getReims() {
    let reimbRes = await fetch(`${apiUrl}/reimbursements`, {
        method: 'GET'
    });

    if (reimbRes.status == 200) {
        reimbs = await reimbRes.json();
        populateReimbs();
    } else {
        console.log('Unable to fetch data.');
    }
}