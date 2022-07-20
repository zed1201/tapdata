package aspect;

import com.tapdata.tm.commons.task.dto.SubTaskDto;
import io.tapdata.aspect.ApplicationStartAspect;
import io.tapdata.aspect.TaskStartAspect;
import io.tapdata.aspect.TaskStopAspect;
import io.tapdata.aspect.task.AspectTaskManager;
import io.tapdata.entity.aspect.AspectManager;
import io.tapdata.entity.utils.InstanceFactory;
import org.bson.types.ObjectId;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class AspectTest {
	@Test
	public void a() {
		AspectTaskManager aspectTaskManager = InstanceFactory.instance(AspectTaskManager.class);
		assertNotNull(aspectTaskManager);
		AspectManager aspectManager = InstanceFactory.instance(AspectManager.class);
		assertNotNull(aspectManager);
		SubTaskDto subTaskDto = new SubTaskDto();
		subTaskDto.setId(new ObjectId());
		aspectManager.executeAspect(new TaskStartAspect().task(subTaskDto));
		aspectManager.executeAspect(new TaskStartAspect().task(subTaskDto));
		aspectManager.executeAspect(new ApplicationStartAspect());
		aspectManager.executeAspect(new TaskStopAspect().task(subTaskDto));
		aspectManager.executeAspect(new TaskStopAspect().task(subTaskDto));
	}
}
