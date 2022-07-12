if (!principal) {
    window.location.href = "./index.html";
}

if (principal.role === 'Manager') {
    let approveB = document.getElementById('approved');
    approveB.style.display = 'inline';
    let denyB = document.getElementById('denied');
    denyB.style.display = 'inline';
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