function onClickSearchButton() {
    const searchField = document.getElementById('searchField');
    const value = searchField.value;
    debugger;
    if (value == '') {
        return;
    }
    const poemString = searchField.getAttribute('poem');
    let count = (poemString.match(new RegExp(value, 'gi')) || []).length;

    searchField.value = value + ' occured ' + count + ' times';
} 

function onPoemReceived() {
    const pack = JSON.parse(this.responseText);
    contentString = pack.content;
    contentTitle = pack.title;

    const poemEl = document.getElementById(contentTitle);
    contentEl = document.createElement('p');
    contentP = document.createElement('p');
    contentP.innerHTML = contentString + '<hr>';

    const searchElP = document.createElement('p');
    const searchField = document.createElement('input');
    searchField.setAttribute('type', 'text');
    searchField.setAttribute('value', '');
    searchField.setAttribute('id', 'searchField');
    searchField.setAttribute('poem', contentString);

    const searchButton = document.createElement('button');
    searchButton.innerHTML = 'search';
    searchButton.addEventListener('click', onClickSearchButton);
    searchElP.appendChild(searchField);
    searchElP.appendChild(searchButton);
   
    const parentEl = poemEl.parentElement.childNodes;

    for (let i = 0; i < parentEl.length; i ++) {
        if (parentEl[i].childElementCount >= 1) {
            parentEl[i].removeChild(parentEl[i].lastChild);
        }
    }
    contentEl.appendChild(searchElP);
    contentEl.appendChild(contentP);

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
