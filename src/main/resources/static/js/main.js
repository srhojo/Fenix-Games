import FgNavbar from './navbarComponent.js'
import GamePage from './gamePageComponent.js'
import PlayersPage from './playersPageComponent.js'
import MatchesPage from "./matchesPageComponent.js";



const games = GamePage;
const players = PlayersPage;
const matches = MatchesPage;

const routes = [{
    path: '/',
    redirect: '/games'
  },
  {
    path: '/games',
    component: games
  },
  {
    path: '/players',
    component: players
  }, {
    path: '/matches',
    component: matches
  }
]

const router = new VueRouter({
  routes // short for `routes: routes`
})

const app = new Vue({
  router,
  components: {
    'fg-navbar': FgNavbar
  },
  data: {
    components: [{
        id: 1,
        value: 'Games',
        uri: '/games'
      },
      {
        id: 2,
        value: 'Players',
        uri: '/players'
      }, {
        id: 3,
        value: 'Matches',
        uri: '/matches'
      }
    ]
  }
}).$mount('#app')