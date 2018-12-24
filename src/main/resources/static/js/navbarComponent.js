export default  {
    props: ['components'],
    template: `
        <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
            <a class="navbar-brand" href="#">Fenix Games</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mainNavbars" aria-controls="mainNavbars" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active" v-for="component in components">
                        <a class="nav-link" href="#">{{ component.value }} <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
        </nav>
            `
};
