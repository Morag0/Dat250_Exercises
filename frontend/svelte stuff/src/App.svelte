<script>
  import PollCreationComponent from './components/pollCreator.svelte';
  import PollVoterComponent from './components/pollVoter.svelte';


  
</script>

<main>
  <h1>Welcome to PollApp</h1>
  <PollCreationComponent />
</main>

<style>
  main {
      text-align: center;
      padding: 1em;
      margin: 0 auto;
  }

  h1 {
      color: #7CB9E8;
  }
</style>
