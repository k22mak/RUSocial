RUSocial::Application.routes.draw do
  resources :messages


  resources :friends

  get "/users/get_friends_pending" => "users#get_friends_pending"

  get "/users/make_a_friend" => "users#make_a_friend"

  get "/users/send_message" => "users#send_message"

  get "/users/get_messages" => "users#get_messages"

  get "/users/find_friends" => "users#find_friends"

  get "/users/login" => "users#login"

  get "/users/look_around" => "users#look_around"

  get "users/change_user_pref" => "users#change_user_pref"

  get "users/json_message_tester" => "users#json_message_tester"

  get "users/json_message_default" => "users#json_message_default"

  get "users/json_message_hash1" => "users#json_message_hash1"

  get "users/json_message_hash2" => "users#json_message_hash2"

  resources :users



  
  resources :user_tables


  resources :registers


  resources :send_user_receiver_messages


  resources :people


  resources :send_username_statuses


  resources :send_username_find_messages


  resources :send_username_find_friends


  resources :send_geos


  resources :send_user_pass_geos


  get "home/index"

  # The priority is based upon order of creation:
  # first created -> highest priority.

  # Sample of regular route:
  #   match 'products/:id' => 'catalog#view'
  # Keep in mind you can assign values other than :controller and :action

  # Sample of named route:
  #   match 'products/:id/purchase' => 'catalog#purchase', :as => :purchase
  # This route can be invoked with purchase_url(:id => product.id)

  # Sample resource route (maps HTTP verbs to controller actions automatically):
  #   resources :products

  # Sample resource route with options:
  #   resources :products do
  #     member do
  #       get 'short'
  #       post 'toggle'
  #     end
  #
  #     collection do
  #       get 'sold'
  #     end
  #   end

  # Sample resource route with sub-resources:
  #   resources :products do
  #     resources :comments, :sales
  #     resource :seller
  #   end

  # Sample resource route with more complex sub-resources
  #   resources :products do
  #     resources :comments
  #     resources :sales do
  #       get 'recent', :on => :collection
  #     end
  #   end

  # Sample resource route within a namespace:
  #   namespace :admin do
  #     # Directs /admin/products/* to Admin::ProductsController
  #     # (app/controllers/admin/products_controller.rb)
  #     resources :products
  #   end

  # You can have the root of your site routed with "root"
  # just remember to delete public/index.html.
   root :to => 'home#index'

  # See how all your routes lay out with "rake routes"

  # This is a legacy wild controller route that's not recommended for RESTful applications.
  # Note: This route will make all actions in every controller accessible via GET requests.
  # match ':controller(/:action(/:id))(.:format)'
end
