namespace CountryListApp
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
            BindingContext = new MainPageViewModel();
        }

        private async void OnShowOnMapButtonClicked(object sender, EventArgs e)
        {
            var button = (Button)sender;
            var mapUrl = button.CommandParameter as string;
            if (!string.IsNullOrEmpty(mapUrl))
            {
                await Navigation.PushAsync(new MapPage(mapUrl));
            }
        }
    }
}
