"use strict";

let superheroes = [
    {name:"Batman", publisher:"DC", alterEgo:"[ENCRYPTED]", firstAppearance:"Detective Comics #27", characters:"[ENCRYPTED]", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/batman.gif`"/>', btn: '<button id="batman-btn">Analyze</button>'},
    {name:"Superman", publisher:"DC", alterEgo:"Kal-El", firstAppearance:"Action Comics #1", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/superman.gif`"/>', btn: '<button id="superman-btn">Analyze</button>'},
    {name:"Flash", publisher:"DC", alterEgo:"Jay Garrick", firstAppearance:"Flash Comics #1", characters:"Barry Allen, Wally West, Bart Allen", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/flash.gif`"/>', btn: '<button id="flash-btn">Analyze</button>'},
    {name:"Green Lantern", publisher:"DC", alterEgo:"Alan Scott", firstAppearance:"All-American Comics #16", characters:"Hal Jordan, Guy Gardner, John Stewart", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/green_lantern.gif`"/>', btn: '<button id="green_lantern-btn">Analyze</button>'},
    {name:"Green Arrow", publisher:"DC", alterEgo:"Oliver Queen", firstAppearance:"More Fun Comics #73", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/green_arrow.gif`"/>', btn: '<button id="green_arrow-btn">Analyze</button>'},
    {name:"Wonder Woman", publisher:"DC", alterEgo:"Princess Diana", firstAppearance:"All Star Comics #8", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/wonder_woman.gif`"/>', btn: '<button id="wonder_woman-btn">Analyze</button>'},
    {name:"Martian Manhunter", publisher:"DC", alterEgo:"J'onn J'onzz", firstAppearance:"Detective Comics #225", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/martian_manhunter.gif`"/>', btn: '<button id="martian_manhunter-btn">Analyze</button>'},
    {name:"Robin/Nightwing", publisher:"DC", alterEgo:"Dick Grayson", firstAppearance:"Detective Comics #38", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/nightwing.gif`"/>', btn: '<button id="nightwing-btn">Analyze</button>'},
    {name:"Blue Beetle", publisher:"DC", alterEgo:"Dan Garret", firstAppearance:"Mystery Men Comics #1", characters:"Ted Kord, Jaime Reyes", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/blue_beetle.gif`"/>', btn: '<button id="blue_beetle-btn">Analyze</button>'},
    {name:"Black Canary", publisher:"DC", alterEgo:"Dinah Drake", firstAppearance:"Flash Comics #86", characters:"Dinah Lance", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/black_canary.gif`"/>', btn: '<button id="black_canary-btn">Analyze</button>'},
    {name:"Spider-Man", publisher:"Marvel", alterEgo:"Peter Parker", firstAppearance:"Amazing Fantasy #15", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/spiderman.gif`"/>', btn: '<button id="spiderman-btn">Analyze</button>'},
    {name:"Captain America", publisher:"Marvel", alterEgo:"Steve Rogers", firstAppearance:"Captain America Comics #1", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/captain_america.gif`"/>', btn: '<button id="captain_america-btn">Analyze</button>'},
    {name:"Iron Man", publisher:"Marvel", alterEgo:"Tony Stark", firstAppearance:"Tales of Suspense #39", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/iron_man.gif`"/>', btn: '<button id="iron_man-btn">Analyze</button>'},
    {name:"Thor", publisher:"Marvel", alterEgo:"Thor Odinson", firstAppearance:"Journey into Mystery #83", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/thor.gif`"/>', btn: '<button id="thor-btn">Analyze</button>'},
    {name:"Hulk", publisher:"Marvel", alterEgo:"Bruce Banner", firstAppearance:"The Incredible Hulk #1", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/hulk.gif`"/>', btn: '<button id="hulk-btn">Analyze</button>'},
    {name:"Wolverine", publisher:"Marvel", alterEgo:"James Howlett", firstAppearance:"The Incredible Hulk #180", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/wolverine.gif`"/>', btn: '<button id="wolverine-btn">Analyze</button>'},
    {name:"Daredevil", publisher:"Marvel", alterEgo:"Matthew Michael Murdock", firstAppearance:"Daredevil #1", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/daredevil.txt`"/>', btn: '<button id="daredevil-btn">Analyze</button>'},
    {name:"Hawkeye", publisher:"Marvel", alterEgo:"Clinton Francis Barton", firstAppearance:"Tales of Suspense #57", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/hawkeye.gif`"/>', btn: '<button id="hawkeye-btn">Analyze</button>'},
    {name:"Cyclops", publisher:"Marvel", alterEgo:"Scott Summers", firstAppearance:"X-Men #1", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/cyclops.txt`"/>', btn: '<button id="cyclops-btn">Analyze</button>'},
    {name:"Silver Surfer", publisher:"Marvel", alterEgo:"Norrin Radd", firstAppearance:"The Fantastic Four #48", characters:"N/A", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/silver_surfer.webp`"/>', btn: '<button id="silver_surfer-btn">Analyze</button>'},
    {name:"The Punisher", publisher:"Marvel", alterEgo:"Frank Castle", firstAppearance:"The Amazing Spider-Man #129", characters:"Microchip", img: '<img src="../img/classified.jpg" class="card-picture" alt="" onclick="this.src=`../img/punisher.gif`"/>', btn: '<button id="punisher-btn">Analyze</button>'}
    ];

function renderHeroCard(x) {
    let html = '<div style="border: 10px solid lightslategray; border-radius: 15px; margin: 0 0 1em 0; background-color: linen;">';
    html = html + '<div style="color: red; margin: 5px 0 5px 0; font-size: 1em;">' + 'Subject:' + '</div>';
    html = html + '<h3 style="margin: .5em 0 .5em 0; font-size: 1.5em"><em>' + x.name + '</em></h3>';
    html = html + '<span>' + x.img + '</span>';
    html = html + '<p>' + 'Alter Ego: ' + x.alterEgo + '</p>';
    html = html + '<p>' + 'Known Associates: ' + x.characters + '</p>';
    html = html + '<p>' + 'Affiliation: ' + x.publisher + '</p>';
    html = html + '<p>' + 'Case Origin: ' + x.firstAppearance + '</p>';
    html = html + '<p style="margin: .5em 0 .5em 0">' + x.btn + '</p>';
    html = html + '</div>';
    return html;
}

function renderHeroCards(superheroes) {
    let html = '';
    for (let i = superheroes.length - 1; i >= 0; i--){
        html = html + renderHeroCard(superheroes[i]);
    }
    return html;
}

function updateSuperHeroesDropDown(e) { // Dynamically adjusts display based on affiliation type selected in dropdown
    e.preventDefault(); // don't submit the form, we just want to update the data
    let selectedPublisher = publisherSelection.value;
    let filteredHeroes = [];
    superheroes.forEach(function(superhero) {
        if (superhero.publisher === selectedPublisher) {
            filteredHeroes.push(superhero);
        }
        console.log(superhero.publisher === selectedPublisher);

    });
    tbody.innerHTML = renderHeroCards(filteredHeroes);
}

function updateSuperHeroesSearch(e) { // Dynamically adjusts display based on letters typed in search bar
    e.preventDefault(); // don't submit the form, we just want to update the data
    let selectedPublisher = searchBar.value;
    let filteredHeroes = [];
    superheroes.filter(function(superheroes) {
        if (superheroes.name.toLowerCase().match(selectedPublisher) || superheroes.alterEgo.toLowerCase().match(selectedPublisher) || superheroes.characters.toLowerCase().match(selectedPublisher) || superheroes.publisher.toLowerCase().match(selectedPublisher) || superheroes.firstAppearance.toLowerCase().match(selectedPublisher)) {
            filteredHeroes.push(superheroes);
        }
    });
    tbody.innerHTML = renderHeroCards(filteredHeroes);
}

superheroes.reverse();
let tbody = document.querySelector('#superheroes');
let submitButton = document.querySelector('#submit');
let searchBar = document.querySelector('#search');
let publisherSelection = document.querySelector('#publisher-selection');

tbody.innerHTML = renderHeroCards(superheroes);

searchBar.addEventListener('keyup', updateSuperHeroesSearch);
submitButton.addEventListener('click', updateSuperHeroesDropDown);

// Computer Speech Synthesis
function computerSpeak(lyrics, pitch) {
    return new Promise((res) => {
        let lyric = new SpeechSynthesisUtterance(lyrics);
        lyric.pitch = pitch;
        lyric.rate = .9;
        speechSynthesis.speak(lyric);
        setTimeout(res, 1500);
    });
}

// Character Descriptions via Speech Synthesis:

// Batman
const analyze_batman = () => {
    return computerSpeak('File encrypted. Access denied.', 0);
};
document.getElementById('batman-btn').addEventListener('click', analyze_batman);

//Superman
const analyze_superman = () => {
    return computerSpeak('Super Man: a powerful alien entity. Multiple special abilities. Only known weakness: Kryptonite.', 0);
};
document.getElementById('superman-btn').addEventListener('click', analyze_superman);

// Flash
const analyze_flash = () => {
    return computerSpeak('After being doused in chemicals and struck by lightning, Barry was granted the gift of super-speed. Now he protects his hometown of Central City as The Flash, the fastest man alive and founding member of the Justice League.', 0);
};
document.getElementById('flash-btn').addEventListener('click', analyze_flash);

// Green Lantern
const analyze_green_lantern = () => {
    return computerSpeak('With the ability to overcome great fear and harness the power of will, test-pilot Hal Jordan was chosen to be the Green Lantern of Sector 2814 inheriting the ring of the dying alien Green Lantern, Ah Bin Sure. He later on went to creating his own power ring from his own will power. Through sheer will power and determination, Hal has established an impressive record of heroism across the galaxy with the help of his fellow Green Lanterns as well as his peers in the Justice League.', 0);
};
document.getElementById('green_lantern-btn').addEventListener('click', analyze_green_lantern);

// Green Arrow
const analyze_green_arrow = () => {
    return computerSpeak('Oliver Queen was a spoiled, thrill-seeking playboy, until he was left stranded on a deserted island for several years. There, he trained to become a master archer in order to survive. After his return home, he used his new-found skills and his wealth to became the costumed vigilante known as Green Arrow.', 0);
};
document.getElementById('green_arrow-btn').addEventListener('click', analyze_green_arrow);

// Wonder Woman
const analyze_wonder_woman = () => {
    return computerSpeak('The princess of the Amazons, armed with superpowers of a god, Wonder Woman is one of Earths most powerful defenders of peace, justice, and equality and a member of the Justice League.', 0);
};
document.getElementById('wonder_woman-btn').addEventListener('click', analyze_wonder_woman);

// Martian Manhunter
const analyze_martian_manhunter = () => {
    return computerSpeak('Sole survivor of the Martian people, John Jones was teleported to Earth decades ago by Dr. Saul Err Dell. Since then, he has adopted Earth as his new home, playing many roles over his time with humanity: detective, secret agent, explorer, and even a founding member of the Justice League.', 0);
};
document.getElementById('martian_manhunter-btn').addEventListener('click', analyze_martian_manhunter);

// Robin/Nightwing
const analyze_nightwing = () => {
    return computerSpeak('After falling out with Batman, Dick Grayson left the Dark Knights side to become a more regular member of the Teen Titans. Inspired by the story of Supermans visit to Kandor, Dick chose to take up his own variant of the Nightwing alias.', 0);
};
document.getElementById('nightwing-btn').addEventListener('click', analyze_nightwing);

// Blue Beetle
const analyze_blue_beetle = () => {
    return computerSpeak('An archaeologist who gains powers from a Blue Beetle Scarab found in Egypt.', 0);
};
document.getElementById('blue_beetle-btn').addEventListener('click', analyze_blue_beetle);

// Black Canary
const analyze_black_canary = () => {
    return computerSpeak('Dee Nuh Lance was born into a family of crime fighters; her mother was a vigilante and her father is a cop. She grew up with the company of heroes, and after years of training, followed in her parents footsteps by assuming the costume, identity, and legacy of her mother Dee Nuh Drake, the Black Canary.', 0);
};
document.getElementById('black_canary-btn').addEventListener('click', analyze_black_canary);

// Spider Man
const analyze_spiderman = () => {
    return computerSpeak('Peter Parker was bitten by a radioactive spider as a teenager, granting him spider-like powers.', 0);
};
document.getElementById('spiderman-btn').addEventListener('click', analyze_spiderman);

// Captain America
const analyze_captain_america = () => {
    return computerSpeak('During World War II, Steve Rogers volunteered to receive the experimental Super-Soldier Serum. Enhanced to the pinnacle of human physical potential and armed with an unbreakable shield, he became Captain America. After a failed mission left him encased in ice for decades, he was found and revived by the Avengers. Later joining their ranks and eventually becoming the teams leader.', 0);
};
document.getElementById('captain_america-btn').addEventListener('click', analyze_captain_america);

// Iron Man
const analyze_iron_man = () => {
    return computerSpeak('Tony uses his vast resources and intellect to make the world a better place as The Invincible Iron Man. Starks super hero identity led him to become a founding member of the Avengers.', 0);
};
document.getElementById('iron_man-btn').addEventListener('click', analyze_iron_man);

// Thor
const analyze_thor = () => {
    return computerSpeak('Thor O Din Son is the All-father of As Guard, God of Thunder, offspring of All-Father O Din & the Elder Earth-Goddess Guy Uh. Combining the powers of both realms makes him an elder-god hybrid and a being of limitless potential. Armed with his enchanted Uru hammer Mjolnir which helps him to channel his godly energies. The mightiest and the most beloved warrior in all of Asgard, a staunch ally for good and one of the most powerful beings in the multiverse/omniverse. Thor is also a founding member of the Avengers.', 0);
};
document.getElementById('thor-btn').addEventListener('click', analyze_thor);

// Hulk
const analyze_hulk = () => {
    return computerSpeak('After being bombarded with a massive dose of gamma radiation while saving a young mans life during the testing of an experimental bomb, Dr. Robert Bruce Banner was transformed into the Incredible Hulk: a green behemoth who is the living personification of rage and pure physical strength.', 0);
};
document.getElementById('hulk-btn').addEventListener('click', analyze_hulk);

// Wolverine
const analyze_wolverine = () => {
    return computerSpeak('James Low Gun Howl Lets once mysterious past is filled with blood, war and betrayal. Possessing an accelerated healing factor, keenly enhanced senses, and bone claws in each hand (along with his skeleton) that are coated in ad uh man tee um; Wolverine is, without question, the ultimate weapon.', 0);
};
document.getElementById('wolverine-btn').addEventListener('click', analyze_wolverine);

// Daredevil
const analyze_daredevil = () => {
    return computerSpeak('As a child, Matt Murdock was blinded by radioactive waste while trying to save an elderly stranger about to get hit by a truck carrying the dangerous material. In turn, his other senses were heightened to superhuman sharpness and he gained a form of "radar sense". By day, he is a successful trial lawyer; but by night, he guards Hells Kitchen as Daredevil: the Man Without Fear.', 0);
};
document.getElementById('daredevil-btn').addEventListener('click', analyze_daredevil);

// Hawkeye
const analyze_hawkeye = () => {
    return computerSpeak('Trained by criminals and inspired by heroes, Clint Barton has grown from a troubled youth into one of the greatest heroes on Earth. The world knows him best as Hawkeye: Earths Mightiest Marksman. A member of the Avengers for many years.', 0);
};
document.getElementById('hawkeye-btn').addEventListener('click', analyze_hawkeye);

// Cyclops
const analyze_cyclops = () => {
    return computerSpeak('The first X-Man, Scott Summers possesses the mutant ability to draw ambient energy from another dimension through his eyes which are actually portals to the dimension, he usually channels this energy into concussive force blasts. He is visually distinctive for the ruby quartz visor he wears to control his devastating power. A born leader, Cyclops succeeded his mentor Professor X to command the X-Men.', 0);
};
document.getElementById('cyclops-btn').addEventListener('click', analyze_cyclops);

// Silver Surfer
const analyze_silver_surfer = () => {
    return computerSpeak('Norrin Radd of Zen La is the mighty herald of Gal Act Us, the devourer of worlds. Gifted with the Power Cosmic and a trusty board thats faster than light speed which he can summon at will whenever needed, Norrin Radd travels to distant stars and throughout the universe as the Silver Surfer.', 0);
};
document.getElementById('silver_surfer-btn').addEventListener('click', analyze_silver_surfer);

// The Punisher
const analyze_punisher = () => {
    return computerSpeak('After his family was killed by the mob, U.S. Marine Special Forces veteran Frank Castle vowed to avenge their deaths and became a one-man army in his personal war against the criminal underworld.', 0);
};
document.getElementById('punisher-btn').addEventListener('click', analyze_punisher);
