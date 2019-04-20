function onPoemReceived() {
    const pack = JSON.parse(this.responseText);
    contentString = pack.content;
    contentTitle = pack.title;

    const poemEl = document.getElementById(contentTitle);
    contentEl = document.createElement('p');
    contentEl.innerHTML = contentString +'<hr>';

    const parentEl = poemEl.parentElement.childNodes;

    for (let i = 0; i < parentEl.length; i ++) {
        if (parentEl[i].childElementCount >= 1) {
            parentEl[i].removeChild(parentEl[i].lastChild);
        }
    }

    poemEl.appendChild(contentEl);
}

function onLoadPoem() {
    const title = this.innerHTML;
    const params = new URLSearchParams();
    params.append('title', title);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onPoemReceived);
    xhr.open('POST', 'protected/poem');
    xhr.send(params); 
}

function createPoemList(titles) {  
    const poemListEl = document.createElement('ul');

    for (let i = 0; i < titles.length; i ++) {
        let title = titles[i];

        let titleEl = document.createElement('li');
        titleEl.innerHTML = title;
        titleEl.setAttribute('id', title);
        titleEl.addEventListener('click', onLoadPoem);
        poemListEl.appendChild(titleEl);
    }
    return poemListEl;
}

function onArtReceived() {
    const titles = JSON.parse(this.responseText);
    const poemListDivEl = document.getElementById('art-content')
    while (poemListDivEl.firstChild) {
        poemListDivEl.removeChild(poemListDivEl.firstChild);
    }
    poemListDivEl.appendChild(createPoemList(titles));
}

function onProfileLoad(user) {
    clearMessages();
    showContents(['profile-content', 'logout-content', 'art-content']);

    const userNameSpandEl = document.getElementById('user-name');
    userNameSpandEl.textContent = user.name;

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onArtReceived);
    xhr.open('GET', 'protected/profile');
    xhr.send();
}
