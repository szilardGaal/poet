
function onCouponsClicked() {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onCouponsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'protected/coupons');
    xhr.send();
}

function onArtLoad() {

    alert("cucc!");
}

function onProfileLoad(user) {
    clearMessages();
    showContents(['profile-content', 'logout-content', 'art-content']);

    const userNameSpandEl = document.getElementById('user-name');
    userNameSpandEl.textContent = user.name;

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onArtLoad);
    xhr.open('GET', 'protected/profile');
    xhr.send();
}
