using Microsoft.Maui.Controls;

namespace CountryListApp
{
    public partial class MapPage : ContentPage
    {
        public MapPage(string mapUrl)
        {
            InitializeComponent();
            MapWebView.Source = mapUrl;
        }
    }
}
